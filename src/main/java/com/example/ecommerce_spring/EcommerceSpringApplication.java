package com.example.ecommerce_spring;

import com.example.ecommerce_spring.dto.CategoryDTO;
import com.example.ecommerce_spring.dto.FakeStoreCategoryResponseDTO;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceSpringApplication {

	public static void main(String[] args) {

			Dotenv dotenv = Dotenv.configure().load();
			dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(EcommerceSpringApplication.class, args);
	}


}
