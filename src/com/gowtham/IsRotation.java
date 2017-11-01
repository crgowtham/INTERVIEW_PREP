package com.gowtham;

public class IsRotation {

	public static void main(String[] args) {
		System.out.println("IsRotation: " + isRotation("waterbottle", "erbottlewad"));
	}

	public static boolean isRotation(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0) {
			String s3 = s1 + s1;
			boolean res = strstr(s3, s2) > 0 ? true : false;
			return res;
		} else {
			return false;
		}

	}

	public static int strstr(String haystack, String needle) {
		for (int i = 0;; i++)
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
	}

}
