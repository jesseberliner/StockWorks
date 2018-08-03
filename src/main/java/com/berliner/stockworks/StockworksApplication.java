package com.berliner.stockworks;


import com.berliner.stockworks.storage.StorageProperties;
import com.berliner.stockworks.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class StockworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockworksApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService)
	{
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
