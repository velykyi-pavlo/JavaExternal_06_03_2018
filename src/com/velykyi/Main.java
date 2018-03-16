package com.velykyi;

import java.util.Arrays;

public class Main {
    public  static void work(){
        try {
            work();
        } finally {
            work();
        }
    }
    static {
        System.out.println(Long.class);
    }


    public static void main(String[] args) {
	// write your code here
     p1:{
         p2:{
             p3:{
                 System.out.println("pe");
                 if (true) break p2;
                 System.out.println("h");
             }
             System.out.println("i");
         }
         System.out.println("hf");
     }
//    work();
    }
}
