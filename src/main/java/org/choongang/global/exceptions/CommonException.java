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
}