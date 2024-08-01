package org.choongang.member.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class MemberAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // System.out.println(authException);
        /**
         * 회원 전용 페이지로 접근한 경우 - /mypage -> 로그인 페이지 이동
         * 관리자 페이지로 접근한 경우 - 응답 코드 401, 에러 페이지 출력
         */

        String uri = request.getRequestURI(); // 주소로 알아봄 | uri -> ContextPath 지우고 QueryString 을 붙여서 이동시킴
        if (uri.contains("/admin")) { // 관리자 페이지
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED); // 응답 코드 401
        } else { // 회원 전용 페이지
            String qs = request.getQueryString();
            String redirectUrl = uri.replace(request.getContextPath(), ""); // uri -> ContextPath 지우고
            if (StringUtils.hasText(qs)) {
                redirectUrl += "?" + qs; // 뒤에 ? 가 붙음
            }

            response.sendRedirect(request.getContextPath() + "/member/login?redirectUrl=" + redirectUrl); // response.sendRedirect(request.getContextPath() + "/member/login") 이 상태는 그냥 메인 페이지로 이동 | 지금은 이전의 페이지로 이동
        }
    }
}