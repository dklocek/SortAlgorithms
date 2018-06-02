package pl.dklocek.sorters.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

public class SortersApplication extends SpringBootServletInitializer{




	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SortersApplication.class);
	}

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SortersApplication.class,args);
	}

}
