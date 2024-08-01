package org.choongang.global.advices;

import lombok.RequiredArgsConstructor;
import org.choongang.member.MemberUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang")
public class CommonControllerAdvice { // 모든 컨트롤러 공통 값 유지 (컨트롤러 실행 전에)

    private final MemberUtil memberUtil;
}