package br.com.cpp.aop.auditable;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
	
	@Around("@annotation(auditable)")
	private Object listar(ProceedingJoinPoint pjp, Auditable auditable) throws Throwable {
		Object valorDeRetorno = pjp.proceed();
		
		StopWatch stopWatch = new StopWatch("AspectJ Auditable");
		stopWatch.start();
		
		logger.info("Início: {}", stopWatch.shortSummary());
		logger.info("Tipo de execução: {}; Advice: {} - {}; Args: {}; Retorno: {}", 
				pjp.getKind(), pjp.toLongString(), Arrays.asList(auditable.value()),
				Arrays.asList(pjp.getArgs()), valorDeRetorno);
		
		stopWatch.stop();
		logger.info("Fim: {}", stopWatch.shortSummary());
		return valorDeRetorno;
	}
}