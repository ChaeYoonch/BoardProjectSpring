package org.choongang.global.exceptions.script;

import org.choongang.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class AlertException extends CommonException { // 자바 스크립트 형태로 메세지 출력
    public AlertException(String message, HttpStatus status) {
        super(message, status);
    }
}