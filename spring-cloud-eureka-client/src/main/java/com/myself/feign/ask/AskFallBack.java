package com.myself.feign.ask;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class AskFallBack implements AskFeignClient {
    @Override
    public String hello(String name) {
        return "服务器故障";
    }
}
