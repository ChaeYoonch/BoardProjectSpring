package org.choongang.file.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class FileUploadServiceTest {

    @Autowired
    private FileUploadService uploadService;

    @Test
    void uploadTest() {
        MockMultipartFile file1 = new MockMultipartFile("file", "test1.png", "images/png", "ABC".getBytes()); // MockMultipartFile -> 임시 파일 | Mock = 모의 객체
        MockMultipartFile file2 = new MockMultipartFile("file", "test2.png", "images/png", "DEF".getBytes());
    }
}