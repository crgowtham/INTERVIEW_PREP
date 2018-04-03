package com.gowtham;

public class CountConsequtiveCharcter {
	
	public static void main(String[] args) {
		String a ="AAABBFFeeCC";
		System.out.println("count : " + count(a));
	}

	public static String count(String str) {

		StringBuilder strB = new StringBuilder(str.toUpperCase());
		int count = 1;
		for (int i = 0; i < strB.length(); i++) {
			if (i < strB.length() - 1 && strB.charAt(i + 1) == strB.charAt(i)) {
				strB.deleteCharAt(i);
				i--;
				count++;
			} else {
				strB.insert(i + 1, count);
				count = 1;
				i++;
			}
		}
		return strB.toString();
	}
}
