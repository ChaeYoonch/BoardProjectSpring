package org.choongang.global.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class CommonException extends RuntimeException {
    private boolean errorCode; // 에러 코드 형태로 넘겨주면 메세지를 직접 가져올 수 있도록 연동하기 위해 작성
    private HttpStatus status; // 조회 가능 | @Getter
    private Map<String, List<String>> errorMessage; // 수정 가능 | @Setter

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 기본 응답 코드는 500 | 직접 설정한 오류 이쪽으로 !
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}