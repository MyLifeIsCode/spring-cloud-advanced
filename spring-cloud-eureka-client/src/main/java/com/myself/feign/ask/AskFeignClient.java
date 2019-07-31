package com.myself.feign.ask;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eureka-client-service",fallback = AskFallBack.class)
@Component
public interface AskFeignClient {
    @GetMapping(value = "/hello/{name}")
    String hello(@PathVariable("name") String name);
}
