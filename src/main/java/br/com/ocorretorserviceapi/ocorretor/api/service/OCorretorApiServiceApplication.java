package br.com.ocorretorserviceapi.ocorretor.api.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OCorretorApiServiceApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OCorretorApiServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(OCorretorApiServiceApplication.class, args);
	}
}
