package com.syboo.shopping.member.command.application.controller;

import com.syboo.shopping.common.CustomPattern;
import com.syboo.shopping.common.ResponseDto;
import com.syboo.shopping.member.command.application.dto.IdRequestDto;
import com.syboo.shopping.member.command.application.dto.SignUpDto;
import com.syboo.shopping.member.command.application.service.MemberService;
import com.syboo.shopping.member.exception.IdContainException;
import com.syboo.shopping.member.exception.IdPatternNotMatchedException;
import com.syboo.shopping.member.exception.PasswordPatternNotMatchedException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * <pre>
 * PackageName : com.syboo.shopping.member.command.application.controller
 * FileName : AuthController
 * Description:
 * ================================================================
 * DATE              AUTHOR        NOTE
 * ----------------------------------------------------------------
 * 2023-09-30        부시연        최초 생성
 * 2023-10-02        부시연        api/v1대신 public url 별도 사용하여 분리
 * </pre>
 *
 * @author 부시연(최초 작성자)
 * @version 1(클래스 버전)
 */
@RestController
@RequestMapping("/public")
public class AuthController {
    private final CustomPattern customPattern;
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final MemberService memberService;
    private static final String LOG_MESSAGE = "[AuthController] signUpDto : {}";

    public AuthController(CustomPattern customPattern, MemberService memberService) {
        this.customPattern = customPattern;
        this.memberService = memberService;
    }

    /** 회원가입 */
    @PostMapping("signup")
    public ResponseEntity<ResponseDto> signup(@Valid @RequestBody SignUpDto signUpDto) {

        log.info("[AuthController] signup Start ======================");
        log.info(LOG_MESSAGE, signUpDto);


        if(!customPattern.idPattern(signUpDto.getMemberId())) {
            throw new IdPatternNotMatchedException();
        }

        if(!customPattern.passwordPattern(signUpDto.getPassword())) {
            throw new PasswordPatternNotMatchedException();
        }

        if(customPattern.idContain(signUpDto.getMemberId(), signUpDto.getPassword())) {
            throw new IdContainException();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/public/login")  // Redirect to the login page
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(new ResponseDto(HttpStatus.CREATED, "회원가입 성공", memberService.signup(signUpDto)), headers, HttpStatus.CREATED);
    }

    /** 아이디 검사 */
    @GetMapping("id")
    public ResponseEntity<ResponseDto> idCheck(@Valid @RequestBody IdRequestDto idRequestDto) {

        log.info("[AuthController] idCheck Start =================");

        return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "회원 아이디 검사", memberService.idCheck(idRequestDto)));
    }

}
