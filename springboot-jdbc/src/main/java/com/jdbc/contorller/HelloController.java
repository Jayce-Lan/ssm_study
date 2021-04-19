package com.jdbc.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jayce Lan on 2021-04-18.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Success";
    }
}
