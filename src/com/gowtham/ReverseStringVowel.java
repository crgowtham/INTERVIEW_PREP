package com.gowtham;

public class ReverseStringVowel {

	/*
	 * Write a function that takes a string as input and reverse only the vowels
	 * of a string.
	 * 
	 * Example 1:
	 * 
	 * Input: "hello" Output: "holle"
	 */

	public String reverseVowels(String s) {
		char[] list = s.toCharArray();
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		for (int i = 0, j = list.length - 1; i < j;) {
			if (!set.contains(list[i])) {
				i++;
				continue;
			}
			if (!set.contains(list[j])) {
				j--;
				continue;
			}
			char temp = list[i];
			list[i] = list[j];
			list[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(list);
	}
}
