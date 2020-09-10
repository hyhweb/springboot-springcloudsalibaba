package com.springclouds.base.controller;

import com.springclouds.base.feignClient.SystemFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create by hyhweb on 2020/9/9 10:27
 */
@RestController
@RequestMapping("/goodsType")
public class GoodsType {

    @Autowired
    private SystemFeignClient systemFeignClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/getAppName")
    public String getAppName() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("system-service");
        String url = String.format("http://%s:%s/%s", serviceInstance.getHost(), serviceInstance.getPort(), "system/base");
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("getAppNameFromFeignClient")
    public String getAppNameFromFeignClient(@RequestParam String name) {
        return systemFeignClient.getName(name);
    }
}
