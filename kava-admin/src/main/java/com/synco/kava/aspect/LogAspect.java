package com.synco.kava.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: cangcang
 * @create: 2018-11-09 18:53
 **/
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
//        saveLog(point);

        return result;
    }

    /**
     * 生成操作日志
     *
     * @param point 切点
     */
    /*private void saveLog(ProceedingJoinPoint point) {
        Date now = new Date();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        try {
            Log logAnnotation = method.getAnnotation(Log.class);
            LogEntity logEntity = new LogEntity();
            logEntity.setCreateDate(now);
            logEntity.setModifyDate(now);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            logEntity.setOperationIp(NetworkUtil.getIpAddress(request));
            logEntity.setOperationTime(new Date());
            logEntity.setOperationMethod(method.getName());
            logEntity.setOperationDesc(logAnnotation.value());
            logMapper.insert(logEntity);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }*/
}
