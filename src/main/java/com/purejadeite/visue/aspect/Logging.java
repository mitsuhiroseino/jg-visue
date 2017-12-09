/* */
package com.purejadeite.visue.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

	private static final Logger LOGGER = LoggerFactory.getLogger(Logging.class);

	@Around("target(com.purejadeite.visue.controller.AbstractController) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object logGeneric(ProceedingJoinPoint joinPoint) throws Throwable {
		String clazzName = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		String text = clazzName + "." + methodName + " - " + args[0].toString();
		LOGGER.info("begin " + text);
		Object result = joinPoint.proceed();
		LOGGER.info("end " + text);
		return result;
    }

}
