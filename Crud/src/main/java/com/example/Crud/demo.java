package com.example.Crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class demo {
    @GetMapping()
    String hello(){
        return "hello";
    }
}
