package org.choongang.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@ActiveProfiles("test") // 환경 변수 설정
@AutoConfigureMockMvc
public class SecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test1() throws Exception { // 컨트롤러 주소 기준 통제
        mockMvc.perform(post("/member/join")
               .with(csrf().asHeader())
               .param("email", "user01@test.org"))
               .andDo(print());
    }

    @Test
    @WithMockUser
    void test2() throws Exception { // mypage
        mockMvc.perform(get("/mypage"))
               .andDo(print());
    }

    @Test
    @WithMockUser(username = "user01@test.org", authorities = "ADMIN")
    void test3() throws Exception { // admin 관리자 페이지
        mockMvc.perform(get("/admin"))
               .andDo(print());
    }
}