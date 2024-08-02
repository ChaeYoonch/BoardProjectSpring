package org.choongang.file.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FileUploadServiceTest {

    @Autowired
    private FileUploadService uploadService;

    @Test
    void uploadTest() {
        // MockMultipartFile -> 임시 파일 | Mock = 모의 객체
    }
}