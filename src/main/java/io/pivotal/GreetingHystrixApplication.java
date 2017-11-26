package io.pivotal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class GreetingHystrixApplication {

    @Bean
    @LoadBalanced
    @Profile("!smoke")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Profile("smoke")
    public RestTemplate stubRunnerRestTemplate() {
        return new RestTemplate();
    }
	
    public static void main(String[] args) {
        SpringApplication.run(GreetingHystrixApplication.class, args);
    }
 
}
