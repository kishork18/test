package com.masaischool.lombok_demo;

import java.util.Arrays;

public class App {
    public static void main( String[] args ){
        EmployeeWithLombok empOne = new EmployeeWithLombok(1, "ABC", "Raj", "1.5LPM", Arrays.asList("Cricket", "Running"));
        EmployeeWithLombok empTwo = new EmployeeWithLombok(1, "BCD", "TN", "2.5LPM", Arrays.asList("Cricket", "Running"));
        
        System.out.println(empOne);
        System.out.println(empTwo);
        
        System.out.println(empOne.hashCode());
        System.out.println(empTwo.hashCode());
        System.out.println(empOne.equals(empTwo));
    }
}
