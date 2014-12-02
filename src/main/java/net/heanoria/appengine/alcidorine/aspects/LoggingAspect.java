package net.heanoria.appengine.alcidorine.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("@annotation(net.heanoria.appengine.alcidorine.aspects.Logging)")
	public Object loggingAround(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Before aspect");
		Object ret = pjp.proceed();
		logger.info("After aspect");
		return ret;
	}
}
