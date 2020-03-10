package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {
        String str="1_1_京剧.html";
        String regex="_(.*?)_";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(str);
        String t="";
        while(m.find()){
            t=m.group(1);
            System.out.println(t);
            System.out.println(t.getClass().getName());
        }

        try {
            int tag = Integer.parseInt(t);
            System.out.println(tag);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }
}


