package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@ComponentScan(basePackages = {"controller", "repository", "service"})
@EntityScan("entity")
@EnableJpaRepositories("repository")
@EnableEurekaClient

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
