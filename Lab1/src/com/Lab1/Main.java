package com.Lab1;

public class Main {

    public static void main(String[] args) {
        compulsory();
    }

    public static void compulsory() {
        System.out.println("Hello World!");
        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n*=3;
        n+=0b10101;
        n+=0xFF;
        n*=6;
        int result;
        if(n%9!=0)
            result = n%9;
        else result = 9;
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
