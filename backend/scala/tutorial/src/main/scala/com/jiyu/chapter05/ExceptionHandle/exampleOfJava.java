package com.jiyu.chapter05.ExceptionHandle;

public class exampleOfJava {
    public static void main(String[] args) {
        try {
            int i = 0;
            int b = 10;
            int c = b / i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("java finally");
        }

        System.out.println("ok~~keep going");
    }
}
