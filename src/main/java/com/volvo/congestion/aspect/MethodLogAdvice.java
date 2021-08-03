package com.volvo.congestion.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * method log advice for add log before or after each method call
 *
 * @author Guitar
 * @version 0.1
 */
@Aspect
@Component
@Slf4j
public class MethodLogAdvice {
    @Around("com.volvo.congestion.aspect.SystemArchitecture.inRestAPILayer()")
    public Object doRestLogActions(ProceedingJoinPoint pjp) throws Throwable {
        return doLogAction(pjp);
    }

    @Around("com.volvo.congestion.aspect.SystemArchitecture.inServiceLayer()")
    public Object doServiceLogActions(ProceedingJoinPoint pjp) throws Throwable {
        return doLogAction(pjp);
    }

    @Around("com.volvo.congestion.aspect.SystemArchitecture.inInfrastructureLayer()")
    public Object doInfrastructureLogActions(ProceedingJoinPoint pjp) throws Throwable {
        return doLogAction(pjp);
    }

    private Object doLogAction(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        String className = pjp.getTarget().getClass().getSimpleName();
        if (pjp.getArgs() == null || pjp.getArgs().length == 0) {
            log.debug(" className:{} call method:{}", className, method.getName());
        } else {
            for (final Object argument : pjp.getArgs()) {
                log.debug(" className:{} call method:{} parameter:{}", className, method.getName(), argument);
            }
        }
        Object retVal = pjp.proceed();
        return retVal;
    }
}
