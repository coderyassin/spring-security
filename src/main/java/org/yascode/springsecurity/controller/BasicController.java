package org.yascode.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basic/")
public class BasicController {

    @GetMapping("/myBasic")
    public String login(){
        return "my name is Eslam";
    }

    @GetMapping("/allBasic")
    public String all(){
        return "I am happy";
    }
}
