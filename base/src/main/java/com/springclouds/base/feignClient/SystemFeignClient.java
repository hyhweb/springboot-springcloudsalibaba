package com.springclouds.base.feignClient;

import com.springclouds.base.feignClient.fallback.SystemFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Create by hyhweb on 2020/9/10 9:30
 *
 * @author Administrator
 */
@FeignClient(value = "system-service", fallback = SystemFallBack.class)
public interface SystemFeignClient {
    @GetMapping("/system/getName")
    String getName(@RequestParam String name);
}
