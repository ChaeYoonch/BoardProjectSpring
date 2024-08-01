package org.choongang.global.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public interface ExceptionProcessor {
    @ExceptionHandler(Exception.class)
    default ModelAndView errorHandler(Exception e) { // 모든 에러 페이지 -> error.html 로 가도록 error.html 에 연동

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 기본 응답 코드 500 으로 설정 -> 필요시 교체할 수 있도록
        if (e instanceof CommonException commonException) { // commonException 얘로 형변환 해서 바로 사용할 수 있도록!
            status = commonException.getStatus();
        }

        ModelAndView mv = new ModelAndView(); // 반환값이 ModelAndView
        mv.setStatus(status); // 위의 status 연동한 것!
        mv.setViewName("error/error");
        return mv;
    }
}