package com.gowtham;

public class LongestSubStringUnique {

	public static String getLongestNonRepeatingString(String inputStr) {
		if (inputStr == null) {
			return null;
		}

		String maxStr = "";
		String tempStr = "";
		for (int i = 0; i < inputStr.length(); i++) {
			// 1. if tempStr contains new character, then change tempStr
			if (tempStr.contains("" + inputStr.charAt(i))) {
				tempStr = tempStr.substring(tempStr.lastIndexOf(inputStr.charAt(i)) + 1);
			}
			// 2. add new character
			tempStr = tempStr + inputStr.charAt(i);
			// 3. replace maxStr with tempStr if tempStr is longer
			if (maxStr.length() < tempStr.length()) {
				maxStr = tempStr;
			}
		}

		return maxStr;
	}
	
	public static void main(String[][] args) {
		System.out.println("longestSubstring: " + getLongestNonRepeatingString("abcdebefghh"));
	}

}
