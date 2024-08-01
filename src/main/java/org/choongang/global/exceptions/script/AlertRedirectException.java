package org.choongang.global.exceptions.script;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

@Getter // 조회용 메서드
public class AlertRedirectException extends AlertException {

    private String url;
    private String target;

    public AlertRedirectException(String message, String url, HttpStatus status, String target) {
        super(message, status);

        target = StringUtils.hasText(target) ? target : "self"; // target 있으면 target, 없으면 self (= 현재 창)

        this.url = url;
        this.target = target;
    }

    public AlertRedirectException(String message, String url, HttpStatus status) { // target 이 없는 상태 -> self 로 고정
        this(message, url, status, null);
    }
}