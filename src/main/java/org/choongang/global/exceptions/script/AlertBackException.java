package org.choongang.global.exceptions.script;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class AlertBackException extends AlertException { // AlertException 하위

    private String target;

    public AlertBackException(String message, HttpStatus status, String target) {
        super(message, status);

        target = StringUtils.hasText(target) ? target : "self";

        this.target = target;
    }

    public AlertBackException(String message, HttpStatus status) {
        this(message, status, null);
    }
}