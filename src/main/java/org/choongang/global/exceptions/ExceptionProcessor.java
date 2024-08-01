package org.choongang.global.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public interface ExceptionProcessor {
    @ExceptionHandler(Exception.class)
    default ModelAndView errorHandler(Exception e) {
        ModelAndView mv = new ModelAndView(); // 반환값이 ModelAndView

        return mv;
    }
}