package com.syboo.shopping.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * packageName  : com.syboo.shopping.main
 * fileName     : MainController
 * author       : 부시연
 * date         : 2023-08-20
 * description  :
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-20       부시연             최초 생성
 */
@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping(value = {"", "/main"})
    public String main() {

        return "main";
    }

    @PostMapping(value="")
    public String redirectMain() {

        return "redirect:/";
    }
}
