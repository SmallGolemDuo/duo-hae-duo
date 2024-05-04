package com.deux.duohaeduo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController implements ErrorController {

    @RequestMapping(value = "/{path:[^.]*}")
    public String redirect() {
        return "forward:/index.html";
    }

    @GetMapping("/champions/{championNameEng}/skins")
    public String championSkins() {
        return "forward:/index.html";
    }

    @GetMapping("/group/groupMembers/{groupId}")
    public String groupMembers() {
        return "forward:/index.html";
    }

}
