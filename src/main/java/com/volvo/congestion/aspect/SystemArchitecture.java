package com.volvo.congestion.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect of system which compose of three layer,
 *
 * @author Guitar
 * @version 0.1
 */
@Aspect
public class SystemArchitecture {

	@Pointcut("within(com.volvo.congestion.calculator.facade.rest.*)")
	public void inRestAPILayer() {
	}

	@Pointcut("within(com.volvo.congestion.calculator.service.impl.*)")
	public void inServiceLayer() {
	}

	@Pointcut("within(com.volvo.congestion.calculator.infrastructure.*)")
	public void inInfrastructureLayer() {
	}
}
