package com.gowtham;

public class BSTAll {

	public static Node root;
	public static Node root1;

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	public static void build123a() {
		root = new Node(2);
		Node lChild = new Node(1);
		Node rChild = new Node(3);
		root.left = lChild;
		root.right = rChild;
	}

	/**
	 * Build 123 using only one pointer variable.
	 */
	public static void build123b() {
		root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
	}

	/**
	 * Build 123 by calling insert() three times. Note that the '2' must be
	 * inserted first.
	 */
	public static void build123c() {
		root = null;
		root = insert(root, 2);
		root = insert(root, 1);
		root = insert(root, 3);
		root = insert(root, 4);
		root = insert(root, 5);
		root = insert(root, 6);
		root = insert(root, 7);
		root = insert(root, 8);
		root = insert(root, 9);
		root = insert(root, 10);
	}

	public static void build123d() {
		root1 = null;
		root1 = insert(root1, 2);
		root1 = insert(root1, 1);
		root1 = insert(root1, 3);
		root1 = insert(root1, 4);
		root1 = insert(root1, 5);
		root1 = insert(root1, 6);
		root1 = insert(root1, 7);
		root1 = insert(root1, 8);
		root1 = insert(root1, 9);
		// root1 = insert(root1, 10);
	}

	private static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}

	private static int size(Node node) {
		if (node == null)
			return 0;
		else {
			return size(node.left) + size(node.right) + 1;
		}
	}

	public static void main(String[] args) {
		build123c();
		build123d();
		System.out.println("size: " + size(root));
		System.out.println("maxdepth: " + maxdepth(root));
		System.out.println("minvalue: " + minvalue(root));
		// inorder(root);
		preorder(root);
		// postorder(root);
		System.out.println("hasPathSum: " + hasPathSum(root, 6));

		System.out.println("sameTree: " + sameTree(root, root1));
		
		System.out.println("isBst: " + isBST(root));
	}

	private static int maxdepth(Node node) {
		if (node == null)
			return 0;
		else {
			int ldepth = maxdepth(node.left);
			int rdepth = maxdepth(node.right);
			return (Math.max(ldepth, rdepth)) + 1;
		}
	}

	private static int minvalue(Node node) {
		Node cur = node;
		while (cur.left != null) {
			cur = node.left;
		}
		return cur.data;
	}

	private static int maxvalue(Node node) {
		Node cur = node;
		while (cur.right != null) {
			cur = node.right;
		}
		return cur.data;
	}

	private static void inorder(Node node) {
		if (node == null)
			return;

		inorder(node.left);
		System.out.println("x: " + node.data);
		inorder(node.right);
	}

	private static void postorder(Node node) {
		if (node == null)
			return;

		inorder(node.left);
		inorder(node.right);
		System.out.println("x: " + node.data);
	}

	private static void preorder(Node node) {
		if (node == null)
			return;

		System.out.println("x: " + node.data);
		inorder(node.left);
		inorder(node.right);
	}

	public static boolean hasPathSum(Node node, int sum) {
		if (node == null)
			return (sum == 0);
		else {
			int subnum = sum - node.data;
			return (hasPathSum(node.left, subnum) || hasPathSum(node.right, subnum));
		}
	}

	static void mirror(Node node) {
		if (node != null) {
			mirror(node.left);
			mirror(node.right);

			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	private static boolean sameTree(Node a, Node b) {
		if (a == null && b == null)
			return true;
		else if (a != null && b != null) {
			return ((a.data == b.data) && sameTree(a.left, b.left) && sameTree(a.right, b.right));
		} else {
			return false;
		}
	}

	private static boolean isBST(Node node) {
		if (node == null)
			return true;

		if (node.left != null && maxvalue(node.left) > node.data)
			return false;
		if (node.right != null && minvalue(node.right) <= node.data)
			return false;
		return (isBST(node.left) && isBST(node.right));
	}
}
