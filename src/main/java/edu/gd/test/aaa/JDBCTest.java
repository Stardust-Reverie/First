package edu.gd.test.aaa;

import edu.gd.test.dao.StudentDao;
import edu.gd.test.entity.Student;
import edu.gd.test.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    public static void test1() throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接
        String url = "jdbc:mysql://localhost:3306/boring?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        //mysql用户名
        String username = "root";
        //mysql密码
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        //执行SQL语句
        String sql = "select * from student";

        PreparedStatement statement = connection.prepareCall(sql);//返回预处理对象

        ResultSet resultSet = statement.executeQuery();//仅处理select

//        ResultSet resultSet = statement.executeUpdate();//处理delete update insert
        while (resultSet.next()){
//            String id = resultSet.getString("id");
            String name = resultSet.getString("stu_name");

            System.out.println("name:" + name);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }


    private static void test2() throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareCall("select * from student");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
//            String id = resultSet.getString("id");
            String name = resultSet.getString("stu_name");

            System.out.println("name:" + name);
        }
        DBUtil.close(resultSet, statement, connection);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        test1();
//        test2();
        List<Student> students = StudentDao.getStudents();
        for (Student student : students){
            System.out.println("id:" + student.getStuNum() + "name" + student.getStuName());
        }
    }


}
