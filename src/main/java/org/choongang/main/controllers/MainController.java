package org.choongang.main.controllers;

import org.choongang.global.exceptions.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController implements ExceptionProcessor { // 메인 페이지

    @GetMapping
    public String index(Model model) { // (속성)에 Model model 추가

        return "front/main/index"; // 주소 X | template 경로
    }
}