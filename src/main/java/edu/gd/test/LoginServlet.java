package edu.gd.test;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String pwd = req.getParameter("password");

        if (name != null && pwd != null){
            //获取session对象
            HttpSession session = req.getSession();
            session.setAttribute("name",name);
            session.setAttribute("password",pwd);
            //跳转到指定页面
            resp.sendRedirect(req.getContextPath() + "admin.jsp");


        }


    }
}
