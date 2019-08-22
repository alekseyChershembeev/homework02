package com.spring.homework2.spring_course2.logging;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Chershembeev_AE
 * Date: 24.07.2019
 * Time: 17:53.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * Log before.
     *
     * @param joinPoint the join point
     */
    @Before("within(com.spring.homework2.spring_course2..*)")
    public void logBefore(JoinPoint joinPoint) {
        LOGGER.info("Method : " + joinPoint.getSignature().getName());
        LOGGER.info("With args : " + Arrays.toString(joinPoint.getArgs()));
    }

//    @AfterThrowing("within(com.spring.homework2.spring_course2..*)")
//    public void exception(JoinPoint joinPoint) {
//
//        LOGGER.error("Exception from " + joinPoint.getClass());
//        LOGGER.error("Method call : " + joinPoint.getSignature().getName());
//        LOGGER.error("With args : " + Arrays.toString(joinPoint.getArgs()));
//    }
}
