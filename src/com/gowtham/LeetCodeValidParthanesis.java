package com.gowtham;

public class LeetCodeValidParthanesis {

	private static final Map<Character, Character> map = new HashMap<Character, Character>() {
		{
			put('(', ')');
			put('{', '}');
			put('[', ']');
		}
	};

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}

}
