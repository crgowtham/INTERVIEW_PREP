package com.gowtham;

public class StrStr {
	
	public static void main(String []args) {
		System.out.println("strstr : " + strstr("abcdedfg", "dc"));
	}
	
	public static int strstr(String haystack  , String needle) {
		for (int i=0; ;i++)
			for (int j=0; ;j++) {
				if (j == needle.length()) return i;
				if (i+j == haystack.length()) return -1;
				if (needle.charAt(j) != haystack.charAt(i + j)) break;
			}
	}

}
