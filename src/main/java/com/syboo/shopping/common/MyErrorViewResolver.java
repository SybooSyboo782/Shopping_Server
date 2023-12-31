package com.syboo.shopping.common;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * packageName  : com.syboo.shopping.common
 * fileName     : MyErrorViewResolver
 * author       : 부시연
 * date         : 2023-12-31
 * description  :
 * @see <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web">...</a>
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31       부시연             최초 생성
 */
public class MyErrorViewResolver  implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        // Use the request or status to optionally return a ModelAndView
        if (status.series() == HttpStatus.Series.CLIENT_ERROR
                || status.series() == HttpStatus.Series.SERVER_ERROR) {
            // We could add custom model values here
            new ModelAndView("error/error");
        }
        return null;
    }
}
