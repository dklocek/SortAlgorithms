package pl.dklocek.sorters.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.dklocek.sorters")
public class SortersApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SortersApplication.class, args);
	}

	/*
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(SortersApplication.class);
	}

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SortersApplication.class,args);
	}
     */
}
