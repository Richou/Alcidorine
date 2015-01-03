package net.heanoria.appengine.alcidorine.aspects;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggingAspect {

	private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
	
	@Around("@annotation(net.heanoria.appengine.alcidorine.aspects.Logging)")
	public Object loggingAround(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		logger.info("Entering " + method.getName() + "() method");
		Object ret = pjp.proceed();
		logger.info("Exiting " + method.getName() + "() method");
		return ret;
	}
}
