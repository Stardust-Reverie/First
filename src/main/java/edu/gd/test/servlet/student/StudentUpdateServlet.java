package edu.gd.test.servlet.student;

import com.mysql.cj.util.StringUtils;
import edu.gd.test.dao.StudentDao;
import edu.gd.test.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/stu/updta")
public class StudentUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String stuNum = req.getParameter("stuNum");
        String stuName = req.getParameter("stuName");

        System.out.println(stuName+"------"+stuNum);
        Student student = StudentDao.getStuById(stuNum);
        System.out.println(student);
        int rows=0;
        if (!StringUtils.isNullOrEmpty(stuName)){
            student.setStuName(stuName);
            System.out.println(student);
            rows  = StudentDao.updataStudent(student);
        }
        if(rows>0){
            req.setAttribute("result","操作成功");
            req.getRequestDispatcher("../editResult.jsp").forward(req,resp);
        }else {
            req.setAttribute("result","操作失败");
            req.getRequestDispatcher("../editResult.jsp").forward(req,resp);
        }

    }
}
