package com.myself.feign.ask;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class AskFallbackFactory implements FallbackFactory<AskFeignClient> {
    @Override
    public AskFeignClient create(Throwable throwable) {
        return null;
    }
//    @Override
//    public AskFeignClient create(Throwable throwable) {
//        return (request) -> {
//            request.put("fallback", "spring-boot-consumer-feign-hystrix by GatewayFallbackFactory");
//            request.put("throwable", throwable.toString());
//
//            return request;
//        };
//    }
}
