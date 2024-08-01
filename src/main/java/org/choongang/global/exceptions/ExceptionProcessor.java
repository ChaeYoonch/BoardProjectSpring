package org.choongang.global.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public interface ExceptionProcessor {
    @ExceptionHandler(Exception.class)
    default ModelAndView errorHandler(Exception e) { // 모든 에러 페이지 -> error.html 로 가도록 error.html 에 연동
        ModelAndView mv = new ModelAndView(); // 반환값이 ModelAndView

        return mv;
    }
}