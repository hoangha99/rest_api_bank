package com.example.web.Controller.Admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/api/")
public class AdminController {

    @GetMapping("admin")
    public String test(){
        return "admin";
    }
}
