package org.choongang.member.validators;

import org.choongang.global.validators.PasswordValidator;
import org.choongang.member.controllers.RequestJoin;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // 의존성 주입 | 기본 스캔 대상
public class JoinValidator implements Validator, PasswordValidator {

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
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String mobile = form.getMobile();

        /* 2. 비밀번호 & 비밀번호 확인 일치 여부 체크 */
        if (!password.equals(confirmPassword)) { // password 와 confirmPassword 가 일치하지 않을 경우
            errors.rejectValue("confirmPassword", "Mismatch.password"); // validations.properties 의 값 연동
        }

        /* 3. 비밀번호 복잡성 체크 (알파벳 대/소문자 각각 1개 이상, 숫자 1개 이상, 특수 문자 1개 이상 포함) : PasswordValidator 연동 */
        if (!alphaCheck(password, false) || !numberCheck(password) || !specialCharsCheck(password)) {
            errors.rejectValue("password","Complexity"); // validations.properties 의 Complexity 연동
        } // ! : 통과 못한 경우 || : and 의 의미
    }
}