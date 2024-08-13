package com.example.demo.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class auth {

    @PostMapping(path="/Login")
    public String Login(){
        return "SA";
    }

    
    @PostMapping(path="/Register")
    public String reg(){
        return "re";
    }

}
