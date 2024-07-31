package org.choongang.member.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.member.controllers.RequestLogin;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler { // 로그인 실패 시 경로

    @Override
    // 로그인 실패시에  유입되는 메서드
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        RequestLogin form = new RequestLogin();
        form.setEmail(request.getParameter("email")); // 위의 form 에서 정보 연동
        form.setPassword(request.getParameter("password"));

        // 로그인 실패 시 로그인 페이지 이동
        response.sendRedirect(request.getContextPath() + "/member/login");
    }
}