package com.yyl.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Aspect
@Component
public class HttpAspect {

    /**
     * 日志对象
     **/
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.yyl.demo.controller..*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //请求url
        logger.info("url={}", request.getRequestURL());

        //请求method
        logger.info("method={}", request.getMethod());

        //请求用户ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        Signature signature = joinPoint.getSignature();
        //类名
        String clazzName = signature.getDeclaringTypeName();
        //方法
        String method = signature.getName();
        logger.info("class_method={}", clazzName + "." + method);

        //请求的参数
//        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturn(Object object) {
        logger.info("response={}", object);
    }
}