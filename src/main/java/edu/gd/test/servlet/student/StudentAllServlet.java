package edu.gd.test.servlet.student;

import com.google.gson.Gson;
import edu.gd.test.dao.StudentDao;
import edu.gd.test.entity.BaseResponse;
import edu.gd.test.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = "/stu/all")
public class StudentAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        List<Student> students = StudentDao.getStudents();

        BaseResponse<List<Student>> response = new BaseResponse<List<Student>>();

        response.setCode(200);
        response.setMsg("请求成功");
        response.setData(students);

        Gson gson = new Gson();
        String json = gson.toJson(response);

        resp.setContentType("application/json");//更改页面类型html类型是text/heml
                                                //application/json是json类型
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(json);

        out.flush();
    }
}
