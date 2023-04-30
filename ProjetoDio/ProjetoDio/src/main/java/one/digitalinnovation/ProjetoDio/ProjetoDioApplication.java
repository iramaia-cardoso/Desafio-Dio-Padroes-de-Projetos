package one.digitalinnovation.ProjetoDio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjetoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDioApplication.class, args);
	}

}
