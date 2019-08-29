package com.qfedu.dt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackStateController {

    @RequestMapping("/backstage")
    public String backState() {
        return "after/backstage";
    }
}
