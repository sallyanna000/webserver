package com.dx.webserver.common.aop;

import com.dx.webserver.common.log.BaseLogger;
import com.dx.webserver.common.utils.DateUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Description 日志记录aop
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 16:42
 */
@Aspect
@Component
public class WebLogAspect extends BaseLogger {

    private DateUtils dateUtils = DateUtils.getInstance();

    /**
     * 记录controller中请求和响应的pointcut
     */
    @Pointcut("execution(public * com.dx.webserver.web.controller..*.*(..))")
    public void webLogAspect() {

    }

    /**
     * 在切点开始时记录请求消息
     *
     * @param point 切点
     * @throws Throwable
     */
    @Before("webLogAspect()")
    public void doBefore(JoinPoint point) throws Throwable {
        // 接收请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求内容
        logger.info("==============request begin======================");
        logger.info("request time: " + dateUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss SSS"));
        logger.info("URL: " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD: " + request.getMethod());
        logger.info("IP: " + request.getRemoteAddr());
        logger.info("CLASS_METHOD: " + point.getSignature().getDeclaringTypeName()
                + "." + point.getSignature().getName());
        Map<String, String[]> args = request.getParameterMap();
        logger.info("args: ");
        args.forEach((k, v)->logger.info("    " + k + ": " + formatList2String(Arrays.asList(v))));
        logger.info("==============request end======================");
    }

    /**
     * 将String列表转换为string形式，以,分隔
     *
     * @param list 需要转换的string列表
     * @return 转换结果
     */
    private String formatList2String(List<String> list) {
        StringBuilder builder = new StringBuilder();
        list.forEach(i-> builder.append(i + ", "));
        return builder.substring(0, builder.lastIndexOf(","));
    }

    /**
     * 不论一个方法是如何结束的，最终通知都会运行。使用@After 注解来声明。最终通知必须准备处理正常返回和异常返回两种情况。通常用它来释放资源。
     */
//    @After("webLogAspect()")
//    public void doAfter(JoinPoint point) {
//        logger.info("=============doAfter-->"
//                + point.getSignature().getDeclaringTypeName()
//                + "."+ point.getSignature().getName()
//                + ", response time: " + System.currentTimeMillis());
//    }

    /**
     * 在切入点return内容之后切入内容，这里记录response信息
     *
     * @param returnVal 返回内容
     */
    @AfterReturning(pointcut = "webLogAspect()", returning = "returnVal")
    public void afterReturn(Object returnVal) {
        logger.info("==============response begin======================");
        logger.info("response time: " + dateUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss SSS"));
        // 处理完请求，返回内容
        logger.info("RESPONSE: " + returnVal);
        logger.info("==============response end======================");
    }

    /**
     * 用来处理当切入内容部分抛出异常之后的处理逻辑
     *
     * @param ex 异常
     */
    @AfterThrowing(pointcut = "webLogAspect()",throwing = "ex")
    public void doAfterThrowing(Throwable ex){
        logger.error("AOP log 切入内容部分出现异常:"+ex.getMessage());
    }
}
