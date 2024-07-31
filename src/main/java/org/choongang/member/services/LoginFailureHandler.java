package org.choongang.member.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.choongang.member.controllers.RequestLogin;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class LoginFailureHandler implements AuthenticationFailureHandler { // 로그인 실패 시 경로

    @Override
    // 로그인 실패시에  유입되는 메서드
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        HttpSession session = request.getSession();

        RequestLogin form = new RequestLogin();
        form.setEmail(request.getParameter("email")); // 위의 form 에서 정보 연동
        form.setPassword(request.getParameter("password"));
        // System.out.println(exception);

        if (exception instanceof BadCredentialsException) { // 아이디 또는 비밀번호가 일치하지 않는 경우 발생하는 예외
            form.setCode("BadCredentials.Login"); // Code = RequestLogin 의 code 커맨드 객체
        }

        form.setSuccess(false); // false 일 경우에만 문구 노출
        session.setAttribute("requestLogin", form); // 명칭 동일하게 입력해야 연동 O

        // 로그인 실패 시 로그인 페이지 이동
        response.sendRedirect(request.getContextPath() + "/member/login");
    }
}