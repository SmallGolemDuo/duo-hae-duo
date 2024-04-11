package com.deux.duohaeduo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class WebController implements ErrorController {

    @GetMapping({"/", "/error"})
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "index.html";
    }

}