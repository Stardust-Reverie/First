package edu.gd.test.dao;
//dao专门用来存储对数据库的操作
import edu.gd.test.entity.Student;
import edu.gd.test.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static Student getStudent(ResultSet resultSet){
        String id = null;
        String name = null;
        try {
            id = resultSet.getString("stu_num");
            name = resultSet.getString("stu_name");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Student student = new Student();
        student.setStuNum(id);
        student.setStuName(name);
        return student;
    }

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareCall("select * from student");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("stu_num");
                String name = resultSet.getString("stu_name");
                Student student = new Student();
                student.setStuNum(id);
                student.setStuName(name);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.close(resultSet, statement, connection);
        return students;
    }

    public static Student getStuById(String stu_num){
        Connection connection = DBUtil.getConnection();
        String sql = "select * from student where stu_num = ?";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student =null;

        try {
            statement = connection.prepareCall(sql);
            //设置SQL的参数
            statement.setString(1,stu_num);//传给第一个问号
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()){
                student = getStudent(resultSet);
                //               String name = resultSet.getString("stu_name");
                //                System.out.println("name:" + name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    public static int delStudentById(String id)
    {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from student where stu_num = ?";
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, id);
            rows = statement.executeUpdate();
            DBUtil.close(null, statement, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    public static void main(String[] args) throws SQLException {
        Student student = getStuById("1877000032");
        System.out.println(student);
    }

}
