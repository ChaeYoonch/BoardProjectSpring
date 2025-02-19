package org.choongang.main.controllers;

import org.choongang.global.exceptions.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController implements ExceptionProcessor { // 메인 페이지

    @GetMapping
    public String index(Model model) { // (속성)에 Model model 추가 -> 추가된 값이 에 추가됨 (범위 바꿀 수 있는 기능이 연계되어 있음)

        model.addAttribute("addCommonScript", List.of("fileManager"));
        model.addAttribute("addScript", List.of("test/form"));

        return "front/main/index"; // 주소 X | template 경로
    }
}