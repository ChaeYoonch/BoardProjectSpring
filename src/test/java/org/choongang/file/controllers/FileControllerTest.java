package org.choongang.file.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MultipartFile[] files; // * files

    @BeforeEach
    void init() {
        MockMultipartFile file1 = new MockMultipartFile("file", "test1.png", "images/png", "ABC".getBytes()); // MockMultipartFile -> 임시 파일 | Mock = 모의 객체
        MockMultipartFile file2 = new MockMultipartFile("file", "test2.png", "images/png", "DEF".getBytes());

        files = new MultipartFile[] {file1, file2}; // * files 연동
    }

    @Test
    void uploadTest() throws Exception {

    }
}