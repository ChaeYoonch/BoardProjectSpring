package org.choongang.global.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.exceptions.script.AlertBackException;
import org.choongang.global.exceptions.script.AlertException;
import org.choongang.global.exceptions.script.AlertRedirectException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public interface ExceptionProcessor {
    @ExceptionHandler(Exception.class)
    default ModelAndView errorHandler(Exception e, HttpServletRequest request) { // 모든 에러 페이지 -> error.html 로 가도록 error.html 에 연동

        ModelAndView mv = new ModelAndView(); // 반환값이 ModelAndView
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 기본 응답 코드 500 으로 설정 -> 필요시 교체할 수 있도록
        String tpl = "error/error"; // 기본 = 에러 페이지
        if (e instanceof CommonException commonException) { // commonException 얘로 형변환 해서 바로 사용할 수 있도록!
            status = commonException.getStatus();

            // AlertRedirectException 연동
            if (e instanceof AlertException) { // AlertException 의 하위 라면
                tpl = "common/_execute_script"; // 자바 스크립트 형태의 Alert 메세지인 경우 common/_execute_script 로 이동함!
                String script = String.format("alert('%s');", e.getMessage());

                if (e instanceof AlertBackException alertBackException) { // AlertBackException 의 하위 라면 | alertBackException -> target 을 가져오기 위해
                    // script += String.format("%s.history.back();", alertBackException.getTarget());
                }

                if (e instanceof AlertRedirectException alertRedirectException) { // AlertRedirectException 의 하위 라면
                    String url = alertRedirectException.getUrl();
                    if (!url.startsWith("http")) { // 외부 URL 이 아닌 경우
                        url = request.getContextPath() + url;
                    }

                    script += String.format("%s.location.replace('%s');", alertRedirectException.getTarget(), url); // alertRedirectException.getUrl() -> url
                }

                mv.addObject("script", script); // 위의 3개 script 연동
            }
        } else if (e instanceof AccessDeniedException) {
            status = HttpStatus.UNAUTHORIZED;
        }

        String url = request.getRequestURI();
        String qs = request.getQueryString();

        if (StringUtils.hasText(qs)) url += "?" + qs;
        // 위 쪽의 ModelAndView mv = new ModelAndView(); 에서 mv 가져옴
        mv.addObject("message", e.getMessage());
        mv.addObject("status", status.value());
        mv.addObject("method", request.getMethod());
        mv.addObject("path", url);
        mv.setStatus(status); // 위의 status 연동한 것!
        mv.setViewName(tpl); // AlertRedirectException 연동된 tpl 가져옴
        return mv;
    }
}