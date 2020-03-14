package springLoggingExample;

import java.lang.reflect.Field;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

@SpringBootApplication
public class Application {
	
	public static void main(final String[] args) {
	    SpringApplication.run(Application.class, args);
	  }

	@Bean
	@Scope("prototype")
	public Logger logger(final InjectionPoint ip) {
		return LoggerFactory.getLogger(Optional.ofNullable(ip.getMethodParameter())
				.<Class<?>>map(MethodParameter::getContainingClass)
				.orElseGet( () ->
				Optional.ofNullable(ip.getField())
				.map(Field::getDeclaringClass)   
				.orElseThrow (IllegalArgumentException::new)
						)
				);
	}
}
