package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        MyTestFramework.testFramework("com.company.MyProgram");
        ClassExaminator classExaminator = new ClassExaminator();
        classExaminator.examinate("com.company.MyProgram");
    }
}
