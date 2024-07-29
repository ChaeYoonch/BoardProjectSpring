package org.choongang.member.validators;

import org.choongang.member.controllers.RequestJoin;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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