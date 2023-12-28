package com.george.chapter10;

import java.util.ArrayList;

public class JavaCollectionDemo {
    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[2] = 11;
        String[] names = {"Scala", "Spark"};
        System.out.println(nums + " " + names);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Scala");
        strings.add("Spark");
        System.out.println(strings + " " + strings.hashCode());
    }
}
