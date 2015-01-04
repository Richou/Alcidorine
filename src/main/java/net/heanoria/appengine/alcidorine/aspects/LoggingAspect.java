package net.heanoria.appengine.alcidorine.aspects;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import net.heanoria.appengine.alcidorine.exceptions.AspectException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());
    
    @Around("@annotation(net.heanoria.appengine.alcidorine.aspects.Logging)")
    public Object loggingAround(ProceedingJoinPoint pjp) {
    	try{
    		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
    		Method method = methodSignature.getMethod();
    		LOGGER.info("Entering " + method.getName() + "() method");
    		Object ret = pjp.proceed();
    		LOGGER.info("Exiting " + method.getName() + "() method");
    		return ret;
    	} catch(Throwable t) {
    		throw new AspectException(t.getMessage());
    	}
    }
}
