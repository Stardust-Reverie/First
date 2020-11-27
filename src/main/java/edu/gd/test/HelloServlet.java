package edu.gd.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/a")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("name","朱东");
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);


        PrintWriter write = resp.getWriter();
        resp.setContentType("text/html");
        write.write("<h1>Hello !</h1>");
        write.flush();
    }
}
