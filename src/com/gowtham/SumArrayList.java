package com.gowtham;

import java.util.ArrayList;
import java.util.List;

public class SumArrayList {
	
	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(4);
		
		System.out.println("Sum: " + sumListRecursive(aList));
	}

	public static int sumListRecursive(List<Integer> numbers) {
        if (numbers.isEmpty() == true ) {
            return 0;
        }
        else {
            /* removed the print statement from here as it prints each time the function is called and else is executed. */
            return numbers.get(0) + sumListRecursive(numbers.subList(1, numbers.size()));
        }
    }
	
}
