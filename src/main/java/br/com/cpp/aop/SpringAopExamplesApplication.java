package br.com.cpp.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class SpringAopExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopExamplesApplication.class, args);
	}
}