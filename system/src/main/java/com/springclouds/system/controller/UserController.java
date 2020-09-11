package com.springclouds.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by hyhweb on 2020/9/9 11:27
 */
@RestController
@RequestMapping("/system")
public class UserController {
    @GetMapping("/getName")
    public String getName(@RequestParam String name) {
        return String.format("come from %s", name);
    }
}
