package org.choongang.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.choongang.global.exceptions.CommonException;
import org.choongang.global.exceptions.ExceptionProcessor;
import org.choongang.global.exceptions.script.AlertRedirectException;
import org.choongang.member.MemberInfo;
import org.choongang.member.services.MemberSaveService;
import org.choongang.member.validators.JoinValidator;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@SessionAttributes("requestLogin")
public class MemberController implements ExceptionProcessor {

    private final JoinValidator joinValidator; // 의존성 주입 O
    private final MemberSaveService memberSaveService;
    //private final MemberUtil memberUtil;
    //private final BoardRepository boardRepository;

    @ModelAttribute
    public RequestLogin requestLogin() {
        return new RequestLogin();
    }

    @GetMapping("/join") // url 주소
    public String join(@ModelAttribute RequestJoin form) { // 회원가입
        /* boolean result = false;
        if (!result) {
            throw new AlertRedirectException("테스트 예외", "/mypage", HttpStatus.BAD_REQUEST);
        } */
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
    /* 로그인 정보 가져오기 4가지 방법 */
    /* @ResponseBody @GetMapping("/test")
    public void test(Principal principal) { // 일반 controller 내에서 void 사용 -> @ResponseBody
        if (principal != null) {
            log.info("로그인 아이디 : {}", principal.getName()); // 로그인한 회원의 정보 : 아이디 확인
        }
    } */

    /*@ResponseBody @GetMapping("/test2")
    public void test2(@AuthenticationPrincipal MemberInfo memberInfo) { // 스프링 시큐리티 -> 현재 로그인 O -> 확인 O
        if(memberInfo != null) {
            log.info("로그인 회원 : {}", memberInfo.toString()); // memberInfo 객체 바로 주입
        }
    } */

    /*@ResponseBody @GetMapping("/test3")
    public void test3() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // setAuthentication : 로그인 상태 강제로 유지

        log.info("로그인 상태 : {}", authentication.isAuthenticated());
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof MemberInfo) { // 로그인 상태 - UserDetails 구현체 (getPrincipal)
            MemberInfo memberInfo = (MemberInfo) authentication.getPrincipal();
            log.info("로그인 회원 : {}", memberInfo.toString());
        } else { // 미로그인 상태 - String / anonymousUser (getPrincipal())
            log.info("getPrincipal() : {}", authentication.getPrincipal());
        }
    } */

    /*@ResponseBody @GetMapping("/test4")
    public void test4() {
        log.info("로그인 여부 : {}", memberUtil.isLogin()); // 로그인 여부
        log.info("로그인 회원 : {}", memberUtil.getMember());
    } */

    /*@ResponseBody @GetMapping("/test5")
    public void test5() {
        /* Board board = Board.builder()
                           .bId("freetalk")
                           .bName("자유 게시판")
                           .build();

        boardRepository.saveAndFlush(board);
        Board board = boardRepository.findById("freetalk").orElse(null);
        board.setBName("(수정)자유 게시판");
        boardRepository.saveAndFlush(board);
    } */

    @GetMapping("/test1")
    @PreAuthorize("isAuthenticated()") // 회원만 접근 가능 -> 권한 통제 O
    public void test1() {
        log.info("test1 - 회원만 접근 가능");
    }
}