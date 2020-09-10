package com.springclouds.base.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by hyhweb on 2020/9/10 9:30
 */
@FeignClient
public interface SystemFeignClient {
    @GetMapping("getName")
    String getName(@RequestParam String name);

}
