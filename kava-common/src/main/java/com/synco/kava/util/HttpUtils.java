package com.synco.kava.util;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * HTTP工具类
 *
 * @author wangshuai
 * @date 2018/12/21
 */
@Log4j2
public class HttpUtils {

    private static final String EMPTY = "";

    private static int connectionTimeOut = 25000;

    private static int socketTimeOut = 25000;

    private static int maxConnectionPerHost = 20;

    private static int maxTotalConnections = 20;

    private static HttpClientBuilder builder;

    private static HttpClient client;

    static {
        builder = HttpClientBuilder.create();
        builder.setConnectionTimeToLive(connectionTimeOut, TimeUnit.SECONDS);
        builder.setMaxConnTotal(maxTotalConnections);
        builder.setMaxConnPerRoute(maxConnectionPerHost);
        client = builder.build();
    }

    /**
     * POST方式提交数据
     *
     * @param url    待请求的URL
     * @param params 要提交的数据
     * @param enc    编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLPost(String url, Map<String, String> params,
                                 String enc) {
        String response = EMPTY;
        HttpPost postMethod = null;
        try {
            postMethod = new HttpPost(url);
            postMethod.setHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=" + enc);
            // 将表单的值放入postMethod中
            List<NameValuePair> parameters = params.entrySet().stream()
                    .map(e -> new BasicNameValuePair(e.getKey(), e.getValue())).collect(Collectors.toList());
            postMethod.setEntity(new UrlEncodedFormEntity(parameters));

            // 执行postMethod
            HttpResponse res = client.execute(postMethod);
            int statusCode = res.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                response = EntityUtils.toString(res.getEntity(), enc);
            } else {
                log.error("响应状态码 = " + statusCode);
                return "响应状态码 = " + statusCode;
            }
        } catch (IOException e) {
            log.error("发生网络异常", e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }
        }

        return response;
    }

    /**
     * 发送HttpPost请求
     *
     * @param strURL 服务地址
     * @param params json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号
     * @return 成功:返回json字符串<br/>
     */
    public static String URLPostToJson(String strURL, String params) {
        HttpPost postMethod = null;
        try {
            postMethod = new HttpPost(strURL);
            postMethod.setHeader("Accept", "application/json");
            postMethod.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
            if (!StringUtils.isEmpty(params)) {
                postMethod.setEntity(new StringEntity(params, "UTF-8"));
            }
            // 执行postMethod
            HttpResponse res = client.execute(postMethod);
            int statusCode = res.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                return EntityUtils.toString(res.getEntity(), "UTF-8");
            } else {
                log.error("响应状态码 = " + statusCode);
                return "error";
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
        // 自定义错误信息
        return "error";
    }

    public static InputStream get(String url) {
        HttpGet getMethod;
        try {
            getMethod = new HttpGet(url);
            // 执行getMethod
            HttpResponse res = client.execute(getMethod);
            int statusCode = res.getStatusLine().getStatusCode();
            Header[] headers = res.getHeaders("content-type");
            if (statusCode == HttpStatus.SC_OK && (ArrayUtils.isEmpty(headers) || !"text/plain".equalsIgnoreCase(headers[0].getValue()))) {
                return res.getEntity().getContent();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * GET方式提交数据
     *
     * @param url    待请求的URL
     * @param params 要提交的数据
     * @param enc    编码
     * @return 响应结果
     * @throws IOException IO异常
     */
    public static String URLGet(String url, Map<String, String> params,
                                String enc) {
        String response = EMPTY;
        HttpGet getMethod = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            if (params != null) {
                params.forEach((k, v) -> {
                    try {
                        builder.addParameter(k, URLEncoder.encode(v != null ? v : EMPTY, enc));
                    } catch (UnsupportedEncodingException e) {
                        log.error(e.getMessage(), e);
                    }
                });
            }
            getMethod = new HttpGet(builder.build());
            getMethod.setHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=" + enc);
            // 执行getMethod
            HttpResponse res = client.execute(getMethod);
            int statusCode = res.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                response = EntityUtils.toString(res.getEntity(), enc);
            }
        } catch (URISyntaxException | IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (getMethod != null) {
                getMethod.releaseConnection();
            }
        }
        return response;
    }
}
