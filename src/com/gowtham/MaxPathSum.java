package com.gowtham;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {

	static int max = Integer.MIN_VALUE;

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

	private static int maxPathSumRecursive(Node node) {

		if (node == null)
			return 0;

		int left = Math.max(maxPathSumRecursive(node.left), 0);
		int right = Math.max(maxPathSumRecursive(node.right), 0);

		max = Math.max(max, node.data + left + right);

		return node.data + Math.max(left, right);

	}

	public static void main(String[] args) {
		build123c();
		System.out.println("maxPathSumRecursive: " + maxPathSumRecursive(root));
		
		System.out.println("binaryTreePaths: " + binaryTreePaths(root));
	}
	
    public static List<String> binaryTreePaths(Node node) {
        
        List<String> result = new ArrayList<String>();
        
        if(node == null) return result;
        
        helper(new String(), node, result);
        
        return result;
        
    }
    
    public static void helper(String current, Node node, List<String> result) {
        
        if(node.left == null && node.right == null) result.add(current + node.data);
        if(node.left != null) helper(current + node.data + "->", node.left, result);
        if(node.right != null) helper(current + node.data + "->", node.right, result);
        
    }

}
