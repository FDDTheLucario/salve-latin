package dev.soulcatcher.salvelatin.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LogManager.getLogger();

    @Pointcut("within(dev.soulcatcher..*)")
    public void logAll() {

    }

    @Before("logAll()")
    public void logMethodStart(JoinPoint jp) {
        var methodSignature = extractMethodSignature(jp);
        var methodArgs = Arrays.toString(jp.getArgs());
        logger.info("{} invoked with provided args: {}", methodSignature, methodArgs);
    }

    @AfterReturning(value = "logAll()", returning = "returnedObj")
    public void logMethodReturn(JoinPoint jp, Object returnedObj) {
        var methodSignature = extractMethodSignature(jp);
        logger.info("{} successfully returned with the value: {}", methodSignature, returnedObj);
    }

    @AfterThrowing(value = "logAll()", throwing = "t")
    public void logMethodException(JoinPoint jp, Throwable t) {
        var methodSignature = extractMethodSignature(jp);
        var exceptionName = t.getClass().getSimpleName();
        logger.warn("{} was thrown in method {} with the message \"{}\"", exceptionName, methodSignature,
                t.getMessage());
    }

    private String extractMethodSignature(JoinPoint jp) {
        return jp.getTarget().getClass().getSimpleName() + "#" + jp.getSignature().getName();
    }
}
