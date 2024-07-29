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
    }
}