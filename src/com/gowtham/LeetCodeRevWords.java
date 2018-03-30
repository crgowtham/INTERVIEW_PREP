package com.gowtham;

public class LeetCodeRevWords {
	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}

	public void reverseWords(char[] s) {
		reverse(s, 0, s.length);
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}

	private void reverse(char[] s, int begin, int end) {
		for (int i = 0; i < (end - begin) / 2; i++) {
			char temp = s[begin + i];
			s[begin + i] = s[end - i - 1];
			s[end - i - 1] = temp;
		}
	}

}
