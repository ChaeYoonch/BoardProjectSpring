package org.choongang.member.validators;

import org.choongang.member.controllers.RequestJoin;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // 의존성 주입 | 기본 스캔 대상
public class JoinValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) { // 실패했는지 아닌지 확인 - hasErrors
            return;
        }

        /**
         * 1. 이미 가입된 회원인지 체크
         * 2. 비밀번호 & 비밀번호 확인 일치 여부 체크
         * 3. 비밀번호 복잡성 체크 (알파벳 대/소문자, 숫자, 특수 문자 포함)
         * 4. 휴대전화번호 형식 체크
         */

        RequestJoin form = (RequestJoin) target;

        /* 2. 비밀번호 & 비밀번호 확인 일치 여부 체크 */
    }
}