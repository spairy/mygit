package com.mvc.func.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.mvc.func.log4j.LogAgent;
import com.mvc.func.log4j.LogFactory;

@Component
@Aspect
@Order(0) /** different Aspect can use this to control order */
public class HelloWorldAspect {

	private static final LogAgent LOG_AGENT = LogFactory.getLogAgent(HelloWorldAspect.class);

	@Pointcut(value = "execution(* com.mvc.func.aop.*Service*.*(..))")
	public void pointCut() {
	}

	@Before(value = "pointCut()")
	public void before(JoinPoint joinPoint) {
		LOG_AGENT.info(">>> Before() aspect executed: Method [" + joinPoint.getSignature().getName() + "]");
	}

	@After(value = "pointCut()")
	public void after(JoinPoint joinPoint) {
		LOG_AGENT.info(">>> After() aspect executed: Method [" + joinPoint.getSignature().getName() + "]");
	}

	@AfterReturning(pointcut = "pointCut()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		LOG_AGENT.info(">>> AfterReturning() aspect executed, Method [" + joinPoint.getSignature().getName()
				+ "], Return Val [" + result + "]");
	}

	/**
	 * must use return object,otherwise the controller will not receive the
	 * return value, also for the @AfterReturning
	 */
	@Around(value = "pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		LOG_AGENT.info(">>> Around() aspect executed: Method [" + joinPoint.getSignature().getName() + "], Auguments "
				+ java.util.Arrays.toString(joinPoint.getArgs()) + "");
		Object object = null;
		try {
			object = joinPoint.proceed();
		} catch (Throwable ex) {
			LOG_AGENT.info(">>> Error in Around() aspect");
			throw ex;
		}
		/** can change return value here */
		LOG_AGENT.info(">>> Around() aspect end, Return Val [" + object + "]");
		return object;

	}

	@AfterThrowing(pointcut = "pointCut()", throwing = "error")
	public void afterThrowing(JoinPoint jointPoint, Throwable error) {
		LOG_AGENT.info(">>> AfterThrowing() aspect executed, Method [" + jointPoint.getSignature().getName() + "]");
		LOG_AGENT.info(">>> AfterThrowing() aspect executed, Error  [" + error + "]");
	}
}
