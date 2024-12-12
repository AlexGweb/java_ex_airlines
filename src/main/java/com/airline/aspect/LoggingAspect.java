@Aspect
@Component
@Slf4j
public class LoggingAspect {
    
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        
        log.info("Method {} executed in {} ms", 
            joinPoint.getSignature().getName(), 
            executionTime);
            
        return proceed;
    }
    
    @AfterThrowing(pointcut = "execution(* com.airline.service.*.*(..))", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {
        log.error("Exception in {}.{} with cause = {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            ex.getCause() != null ? ex.getCause() : "NULL");
    }
} 