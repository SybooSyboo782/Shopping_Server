package com.syboo.shopping.member.command;

import com.google.gson.Gson;
import com.syboo.shopping.common.CustomPattern;
import com.syboo.shopping.member.command.application.controller.MemberController;
import com.syboo.shopping.member.command.application.dto.SignUpDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * <pre>
 * PackageName : com.syboo.shopping.member.command
 * FileName : MemberControllerTest
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-09-30        부시연        최초 생성
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    MemberController memberController;

    @Autowired
    private MockMvc mock;

    @Mock
    private CustomPattern customPattern;

    @Test
    @DisplayName("회원가입용 컨트롤러 동작 확인 테스트")
    void testSignUp() throws Exception {

        SignUpDto signUpDto = SignUpDto.builder()
                .memberId("new_user")
                .password("test1234!")
                .build();

        String json = new Gson().toJson(signUpDto); // dto 를 json 형식의 String 으로 만들기

        mock.perform(post("/public/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }
}
