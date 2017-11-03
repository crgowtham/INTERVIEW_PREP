package com.gowtham;

public class ReverseString {
	
	public static void main(String[] args) {
		System.out.println("revers string: " + reverseString("abcdefg"));
	}
	
	
	public static String reverseString(String s) {
		if(s == null || s.length() == 0 || s.length() == 1) return s;
		
		char[] word = s.toCharArray();
		for(int i=0,j=s.length()-1; i<j ; i++,j-- ) {
			char temp = word[i];
			word[i] = word[j];
			word[j] = temp;
		}
		
		return new String(word);
	}

}
