package com.george.chapter08.innerClass;

public class JavaInnerClass {
    public static void main(String[] args) {
        OuterClass outer1 = new OuterClass();
        OuterClass outer2 = new OuterClass();

        OuterClass.InnerClass inner1 = outer1.new InnerClass();
        OuterClass.InnerClass inner2 = outer2.new InnerClass();
        inner1.test(inner2);
        inner2.test(inner1);
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();

    }
}

class OuterClass{ // 外部类
    class InnerClass{ // 成员内部类
        public void test(InnerClass ic){
            System.out.println(ic);
        }
    }

    static class StaticInnerClass{ // 静态内部类

    }
}
