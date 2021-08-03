package com.volvo.congestion.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * deal with error when exception occured
 *
 * @author Guitar
 * @version 0.1
 */
@Aspect
@Component
@Slf4j
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut = "com.volvo.congestion.aspect.SystemArchitecture.inInfrastructureLayer()", throwing = "ex")
	public void doInfrastructureLogActions(Exception ex) {
		log.error(" system error {} ", ex);
	}

	@AfterThrowing(pointcut = "com.volvo.congestion.aspect.SystemArchitecture.inServiceLayer()", throwing = "ex")
	public void doServiceLogActions(Exception ex) {
		log.error(" business error {} ", ex);
	}
}
