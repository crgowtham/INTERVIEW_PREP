package com.gowtham;

import java.util.*;

class RemoveDupChars {
	public String remove(String inputString) {
		String result = "";
		Set<String> inputSet = new LinkedHashSet<String>(); // LinkedHashSet
															// maintains the
															// order in which
															// elements are
															// inserted
		for (int i = 0; i < inputString.length(); i++) {
			inputSet.add(String.valueOf(inputString.charAt(i)));
		}
		for (String a : inputSet) {
			result += a;
		}
		return result;
	}

	/* Method to remove duplicates in a sorted array */
	static String removeDupsSorted(String str) {
		int res_ind = 1, ip_ind = 1;

		// Character array for removal of duplicate characters
		char arr[] = str.toCharArray();

		/* In place removal of duplicate characters */
		while (ip_ind != arr.length) {
			if (arr[ip_ind] != arr[ip_ind - 1]) {
				arr[res_ind] = arr[ip_ind];
				res_ind++;
			}
			ip_ind++;

		}

		str = new String(arr);
		return str.substring(0, res_ind);
	}

	/*
	 * Method removes duplicate characters from the string This function work
	 * in-place and fills null characters in the extra space left
	 */
	static String removeDups(String str) {
		// Sort the character array
		char temp[] = str.toCharArray();
		Arrays.sort(temp);
		str = new String(temp);

		// Remove duplicates from sorted
		return removeDupsSorted(str);
	}

	public static void main(String java2carrer[]) {
		RemoveDupChars rd = new RemoveDupChars();
		System.out.println(rd.remove("abdacdabcd"));
	}
}