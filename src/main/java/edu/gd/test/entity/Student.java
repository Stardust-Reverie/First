package edu.gd.test.entity;
//entity专门放实体类
public class Student {
    private String stuNum;
    private String stuName;

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public Student() {}

    public Student(String stuNum, String stuName) {
        this.stuNum = stuNum;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
