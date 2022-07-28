package com.ll.exam;

import com.ll.exam.article.Dto.ArticleDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Rq {
    private final HttpServletResponse resp;
    private final HttpServletRequest req;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
//        /gugudan?dan=3&limit=5
        this.req = req;
        this.resp = resp;

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
    }

    public String getParam(String paramName, String defaultValue) {
        String value = req.getParameter(paramName);

        if (value == null || value.trim().length()==0) {
            System.out.println(value);
            return defaultValue;
        }
        return value;
    }

    public long getIntParam(String paramName, long defaultValue) {
        String value = req.getParameter(paramName);

        if (value == null) {
            System.out.println(value);
            return defaultValue;
        }

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public void setAttr(String name, Object value) {
        req.setAttribute(name, value);
    }

    public void view(String path) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMethod() {
        return req.getMethod();
    }

    public long getLongPathValueByIndex(int index, long defaultValue) {
        String value = getPathValueByIndex(index, null);

        if ( value == null ) {
            return defaultValue;
        }

        try {
            return Long.parseLong(value);
        }
        catch ( NumberFormatException e ) {
            return defaultValue;
        }
    }

    public String getPathValueByIndex(int index, String defaultValue) {
        String[] bits = req.getRequestURI().split("/");

        try {
            return bits[4 + index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return defaultValue;
        }
    }

    public String getActionPath() {
        String[] bits = req.getRequestURI().split("/");

        return "/%s/%s/%s".formatted(bits[1], bits[2], bits[3]);
    }

    public void historyBack(String msg) {
        if (msg != null && msg.trim().length() > 0) {
            println("""
                    <script>
                    alert("%s");
                    </script>
                    """.formatted(msg));
        }

        println("""
                <script>
                history.back();
                </script>
                """);
    }

    public void replace(String uri, String msg) {

        if (msg != null && msg.trim().length() > 0) {
            println("""
                    <script>
                    alert("%s");
                    </script>
                    """.formatted(msg));
        }

        println("""
                <script>
                location.replace("%s");
                </script>
                """.formatted(uri));
    }

    public void println(String str) {
        print(str + "\n");
    }

    public void print(String str) {
        try {
            resp.getWriter().append(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}