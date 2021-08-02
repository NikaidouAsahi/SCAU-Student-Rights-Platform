package com.vincent.studentrightsplatform;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping({"/index", "/"})
    public String index() {
        String time = Utilities.getDateAndTime(System.currentTimeMillis());
        return "<!DOCTYPE html><html><body><head><meta charset=\"utf-8\"><title>404 Not Found</title></head><div><br><label>404 Not Found</label><br><br><label>" + time + "</label></div></body></html>";
    }
}
