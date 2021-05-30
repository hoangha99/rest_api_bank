package com.example.web.Controller;

import com.example.web.Repository.UserRepository;
import com.example.web.config.WebSecurityConfig;
import com.example.web.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    WebSecurityConfig webSecurityConfig;

    @Autowired
    UserRepository userRepository;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("index")
    public String home(){
        return "index";
    }

    @GetMapping("/403")
    public String error(){
        return "403Page";
    }

}
