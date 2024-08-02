package org.choongang.file.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController { //REST 형태로 작업

    @PostMapping("/upload") // file 은 post 형태로 넘어오기 때문!
    public void upload(@RequestPart("file") MultipartFile[] files) { // "file" 이 이름 | 1개는 낱개로 | 여러 개는 배열 형태로

    }
}