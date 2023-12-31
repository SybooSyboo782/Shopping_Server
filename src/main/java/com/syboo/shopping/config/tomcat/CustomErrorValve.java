package com.syboo.shopping.config.tomcat;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ErrorReportValve;
import org.apache.coyote.ActionCode;

import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * packageName  : com.syboo.shopping.config.tomcat
 * fileName     : CustomErrorValve
 * author       : 부시연
 * date         : 2023-12-31
 * description  : 톰캣 ErrorReportValve 를 상속 받아 사용자 정의 에러페이지로 리다이렉트
 * ===========================================================
 * DATE             AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31       부시연             최초 생성
 */
public class CustomErrorValve extends ErrorReportValve {
    @Override
    protected void report(Request request, Response response, Throwable throwable) {
        int statusCode = response.getStatus();
        if (statusCode >= 400 && response.getContentWritten() <= 0L && response.setErrorReported()) {
            AtomicBoolean result = new AtomicBoolean(false);
            response.getCoyoteResponse().action(ActionCode.IS_IO_ALLOWED, result);
            if (result.get()) {
                StringBuilder sb = getStringBuilder();
                try {
                    response.setContentType("text/html");
                    response.setCharacterEncoding("utf-8");
                    Writer writer = response.getReporter();
                    if (writer != null) {
                        writer.write(sb.toString());
                        response.finishResponse();
                    }
                } catch (IllegalStateException | IOException var19) {
                }
            }
        }
    }

    private static StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html><html lang=\"");
        sb.append("<head>");
        sb.append("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        sb.append("</head><body>");
        sb.append(" <script type=\"text/javascript\">");
        sb.append("     let errorUrl = window.location.origin + '/error'; ");
        sb.append("     window.location.href = errorUrl;");
        sb.append(" </script>");
        sb.append("</body>");
        sb.append("</html>");
        return sb;
    }
}
