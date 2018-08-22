package com.gowtham;

public class PhoneNoLetterComb {
	/*
	 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce",
	 * "cf"].
	 */
	Map<Character, List<Character>> map = new HashMap<>();
	StringBuilder strBuilder = new StringBuilder();
	List<String> result = new ArrayList<>();

	private void letterCombinationsHelper(char[] digits, int idx) {
		if (idx >= digits.length) {
			result.add(strBuilder.toString());
			return;
		}

		char digit = digits[idx];
		List<Character> letters = map.get(digit);

		for (char c : letters) {
			strBuilder.append(c);
			letterCombinationsHelper(digits, idx + 1);
			strBuilder.deleteCharAt(strBuilder.length() - 1);
		}
	}

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return result;
		}

		map.put('1', Collections.emptyList());
		map.put('2', Arrays.asList('a', 'b', 'c'));
		map.put('3', Arrays.asList('d', 'e', 'f'));
		map.put('4', Arrays.asList('g', 'h', 'i'));
		map.put('5', Arrays.asList('j', 'k', 'l'));
		map.put('6', Arrays.asList('m', 'n', 'o'));
		map.put('7', Arrays.asList('p', 'q', 'r', 's'));
		map.put('8', Arrays.asList('t', 'u', 'v'));
		map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

		letterCombinationsHelper(digits.toCharArray(), 0);

		return result;
	}
}
