package org.choongang.global.exceptions.script;

import org.springframework.http.HttpStatus;

public class AlertRedirectException extends AlertException {
    public AlertRedirectException(String message, String url, HttpStatus status, String target) {

    }
}