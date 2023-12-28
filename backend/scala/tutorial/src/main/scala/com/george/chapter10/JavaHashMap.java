package com.george.chapter10;

import java.util.HashMap;

public class JavaHashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap();
        hm.put("n1",100);
        hm.put("n2",200);
        hm.put("n3",300);
        hm.put("n4",400);
        hm.put("n5",500);
        System.out.println(hm);
        System.out.println(hm.get("n1"));
    }
}
