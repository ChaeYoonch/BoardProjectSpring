package org.choongang.global.exceptions;

import org.springframework.web.servlet.ModelAndView;

public interface ExceptionProcessor {

    default ModelAndView errorHandler() {

    }
}