package com.gowtham;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowAvg {

    static double previousSum = 0.0;
    static int maxSize;
   static  Queue<Integer> window;

    /** Initialize your data structure here. */
    public static void MovingAverage(int size) {
        
        maxSize = size;
        window = new LinkedList<Integer>();
 
    }
    
    public static double next(int val) {
        if(window.size() == maxSize) {
            
            previousSum -= window.remove();
            
        }
        
        window.add(val);
        previousSum += val;
        return previousSum / window.size();
        
    }
    
    public static void main(String[] args) {
    	MovingAverage(3);
    	System.out.println("1: " + next(1));
    	System.out.println("10: " + next(10));
    	System.out.println("3: " + next(3));
    	System.out.println("5: " + next(5));
    	System.out.println("1: " + next(1));
    	System.out.println("2: " + next(2));
    	
    }

}