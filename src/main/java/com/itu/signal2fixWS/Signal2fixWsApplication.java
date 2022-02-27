package com.itu.signal2fixWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Signal2fixWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Signal2fixWsApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfiguration(){
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("*")
//						.allowedHeaders("*")
//						.allowedMethods("*");
//			}
//		};
//	}
}
