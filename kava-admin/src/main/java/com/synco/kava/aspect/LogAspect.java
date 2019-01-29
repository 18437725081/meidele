package com.synco.kava.aspect;

import cn.hutool.core.date.DateUtil;
import com.synco.kava.annotation.Log;
import com.synco.kava.entity.OperationLog;
import com.synco.kava.util.NetworkUtil;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : wangshuai
 * @create : 2019/01/29
 */

@Aspect
@Component
@Log4j2
public class LogAspect {

    /**
     * 创建一个切入点
     */
    @Pointcut("@annotation(com.synco.kava.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Object result = point.proceed();
        //生成操作日志
        saveLog(point);

        return result;
    }

    /**
     * 生成操作日志
     *
     * @param point 切点
     */
    private void saveLog(ProceedingJoinPoint point) {
        Date now = new Date();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            Log logAnnotation = method.getAnnotation(Log.class);
            OperationLog operationLog = new OperationLog();
            operationLog.setCreateDate(now);
            operationLog.setModifyDate(now);
            operationLog.setIp(NetworkUtil.getIpAddress(request));
            operationLog.setMethod(method.getName());
            Parameter[] parameters = method.getParameters();
            List<String> paramList = Arrays.stream(parameters).map(Parameter::getName).collect(Collectors.toList());
            String[] params = paramList.toArray(new String[paramList.size()]);
            operationLog.setParams(params);
            operationLog.setOperationTime(DateUtil.formatTime(now));
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
}
