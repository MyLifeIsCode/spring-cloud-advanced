package com.myself.controller;

import com.myself.feign.ask.AskFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class AskController {

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AskFeignClient askFeignClient;

    @RequestMapping(value = "/ask")
    public String ask(){
        String askHelloFromService = restTemplate.getForEntity("http://EUREKA-CLIENT-SERVICE/hello/{name}",String.class,name).getBody();
        return askHelloFromService;
    }

    @RequestMapping(value = "/feignHello")
    public String feignHello(){
        return askFeignClient.hello("haha");
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
