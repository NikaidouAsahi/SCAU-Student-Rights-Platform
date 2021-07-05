package com.vincent.studentrightsplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Fucker {
    @Autowired
    @GetMapping({"/index", "/"})
    public String index() {
        return "index";
    }
}
