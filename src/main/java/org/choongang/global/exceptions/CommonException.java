package org.choongang.global.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class CommonException extends RuntimeException {
    private HttpStatus status; // 조회 가능
    private Map<String, List<String>> errorMessage; // 수정 가능

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 기본 응답 코드는 500 | 직접 설정한 오류 이쪽으로 !
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}