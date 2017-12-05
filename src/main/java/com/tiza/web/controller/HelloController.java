package com.tiza.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: HelloController
 * Author: DIYILIU
 * Update: 2017-12-05 16:57
 */

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String hello(){

        return "Greetings from Spring Boot!";
    }
}
