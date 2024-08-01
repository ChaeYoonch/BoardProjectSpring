package org.choongang.global.exceptions.script;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter // 조회용 메서드
public class AlertRedirectException extends AlertException {

    private String url;
    private String target;

    public AlertRedirectException(String message, String url, HttpStatus status, String target) {
        super(message, status);
    }
}