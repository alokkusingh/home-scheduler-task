package com.alok.home.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class HomeSchedulerServiceApplication {

	@Autowired
	private RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(HomeSchedulerServiceApplication.class, args);
	}

	@Scheduled(cron = "0 0 */12 * * ?")
	public void scheduleExpenseSheetRefresh() {
		log.info("Cron - ExpenseSheetRefresh");
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/home/etl/gsheet/refresh/expense", String.class);
		log.info("Response Code: {}, Response Message: {}", response.getStatusCode(), response.getBody());
	}

	@Scheduled(cron = "0 5 9 * * ?")
	public void scheduleTaxSheetRefresh() {
		log.info("Cron - TaxSheetRefresh");
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/home/etl/gsheet/refresh/tax", String.class);
		log.info("Response Code: {}, Response Message: {}", response.getStatusCode(), response.getBody());
	}

	@Scheduled(cron = "0 10 9 * * ?")
	public void scheduleInvestmentSheetRefresh() {
		log.info("Cron - InvestmentSheetRefresh");
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/home/etl/gsheet/refresh/investment", String.class);
		log.info("Response Code: {}, Response Message: {}", response.getStatusCode(), response.getBody());
	}

	@Scheduled(cron = "0 15 9 * * ?")
	public void scheduleOdionSheetRefresh() {
		log.info("Cron - OdionSheetRefresh");
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/home/etl/gsheet/refresh/odion/transactions", String.class);
		log.info("Response Code: {}, Response Message: {}", response.getStatusCode(), response.getBody());
	}

}
