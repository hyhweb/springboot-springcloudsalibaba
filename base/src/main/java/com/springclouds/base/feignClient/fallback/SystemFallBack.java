package com.springclouds.base.feignClient.fallback;

import com.springclouds.base.feignClient.SystemFeignClient;
import org.springframework.stereotype.Component;

/**
 * Create by hyhweb on 2020/9/10 10:49
 *
 * @author Administrator
 */
@Component
public class SystemFallBack implements SystemFeignClient {
    @Override
    public String getName(String name) {
        return "网络异常";
    }
}
