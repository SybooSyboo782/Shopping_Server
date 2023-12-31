package com.syboo.shopping.config.tomcat;

import org.apache.catalina.core.StandardHost;
import org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * packageName  : com.syboo.shopping.config.tomcat
 * fileName     : ErrorValveConfig
 * author       : 부시연
 * date         : 2023-12-31
 * description  : 톰캣 에러
 * @see <a href="https://github.com/spring-projects/spring-boot/issues/21257">...</a>
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31       부시연             최초 생성
 */
@Component
public class ErrorValveConfig extends TomcatWebSocketServletWebServerCustomizer {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addContextCustomizers(context -> {
            if (context.getParent() instanceof StandardHost parent) {
                parent.setErrorReportValveClass(CustomErrorValve.class.getName());
                parent.addValve(new CustomErrorValve());
            }
        });
    }

    @Override
    public int getOrder() {
        return 100; // needs to be AFTER the one configured with TomcatWebServerFactoryCustomizer
    }
}
