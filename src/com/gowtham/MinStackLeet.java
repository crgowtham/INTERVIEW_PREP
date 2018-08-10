package com.gowtham;

public class MinStackLeet {

	class MinStack {
		private Stack<Integer> stack = new Stack<>();
		private Stack<Integer> minStack = new Stack<>();

		public void push(int x) {
			stack.push(x);
			if (minStack.isEmpty() || x <= minStack.peek()) {
				minStack.push(x);
			}
		}

		public void pop() {
			if (stack.pop().equals(minStack.peek()))
				minStack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return minStack.peek();
		}
	}

}
