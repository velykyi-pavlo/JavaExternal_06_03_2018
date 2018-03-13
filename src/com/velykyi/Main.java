package com.velykyi;

public class Main {
    public void f(Integer a){
        System.out.println( " integer");
    }
    public void f(Object a){
        System.out.println( " Object");
    }

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.f(new Double(5));
    }
}
