package org.choongang.file.exceptions;

import org.choongang.global.exceptions.script.AlertBackException;
import org.springframework.http.HttpStatus;

public class FileNotFoundException extends AlertBackException { // 메세지 띄우고 뒤로 back 함
    public FileNotFoundException() {
        super("NotFound.file", HttpStatus.NOT_FOUND); // 응답 코드 404
        setErrorCode(true); // CommonException 의 errorCode 연동
    }
}