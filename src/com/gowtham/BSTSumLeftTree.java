package com.gowtham;

public class BSTSumLeftTree {
	
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
	
    public static int sumOfLeftLeaves(Node root) {
    	
    	if (root==null) return 0;
    	
    	int count = 0;
    	
    	if(root.left != null) {
    		if(root.left.left == null && root.left.right == null) count += root.left.data;
    		else
    			count +=sumOfLeftLeaves(root.left);
    	}
    	
    	count +=sumOfLeftLeaves(root.right);
    	
    	return count;
    }
    
    public static void main(String[] args){
    	Node root = new Node(1);
    	root.left = new Node(2);
    	root.right = new Node(3);
    	root.left.left = new Node(4);
    	root.left.left = new Node(5);
    	
    	System.out.println("SumLeft: " + sumOfLeftLeaves(root));
    	
    }

}
