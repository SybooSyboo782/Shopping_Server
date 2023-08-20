package com.syboo.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * packageName  : com.syboo.shopping
 * fileName     : ShoppingApplication
 * author       : 부시연
 * date         : 2023-08-20
 * description  :
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-08-20       부시연             최초 생성
 */
@SpringBootApplication
@EnableJpaRepositories("com.syboo.shopping")
public class ShoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }

}
