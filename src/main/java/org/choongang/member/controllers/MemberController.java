package org.choongang.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.member.services.MemberSaveService;
import org.choongang.member.validators.JoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@SessionAttributes("requestLogin")
public class MemberController {

    private final JoinValidator joinValidator; // 의존성 주입 O
    private final MemberSaveService memberSaveService;

    @ModelAttribute
    public RequestLogin requestLogin() {
        return new RequestLogin();
    }

    @GetMapping("/join") // url 주소
    public String join(@ModelAttribute RequestJoin form) { // 회원가입
        return "front/member/join";
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors) { // 회원가입 프로세스 | @Valid = 검증 | form 형태로 넘김 | 값이 없거나 검증 실패시 Errors 로 이동| 만들어지는 기준 = 앞의 RequestJoin 즉, 클래스명

        joinValidator.validate(form, errors); // 커맨드 객체 = form, 에러 = errors

        if (errors.hasErrors()) { // error 가 있으면
            return "front/member/join"; // 여기로 이동
        }
        // 여기 부분 들어갈 내용 : Service
        memberSaveService.save(form); // 회원 가입 처리
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String login(@Valid @ModelAttribute RequestLogin form, Errors errors) { // 로그인 | RequestLogin 커맨드 객체 form 형태 | 검증 -> Errors 추가
        String code = form.getCode();
        if (StringUtils.hasText(code)) {
            errors.reject(code, form.getDefaultMessage()); // LoginFailureHandler 의 form.getDefaultMessage()

            // 비밀번호 만료된 경우 비밀번호 재설정 페이지로 이동
            if (code.equals("CredentialsExpired.Login")) {
                return "redirect:/member/password/reset"; // 비밀번호 재설정 페이지
            }
        }
        return "front/member/login";
    }

    @ResponseBody @GetMapping("/test")
    public void test(Principal principal) { // 일반 controller 내에서 void 사용 -> @ResponseBody | 로그인한 회원 정보의 아이디 확인

    }
}