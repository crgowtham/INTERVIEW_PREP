package com.gowtham;

import java.util.List;

public class CompareBST {

	static class NodeBST {
		int data;
		Node left;
		Node right;

		public NodeBST(int data) {
			this.data = data;
		}
	}

	// function to insert elements of the
	// tree to map m
	void storeInorder(NodeBST root, List<Integer> v)
	{
	    if (root == null)
	        return;
	    storeInorder(root.left, v);
	    v.add(root.data);
	    storeInorder(root.right, v);
	}

	// function to check if the two BSTs contain
	// same set of elements
	bool checkBSTs(NodeBST root1, NodeBST root2)
	{ 
	    // Base cases 
	    if (!root1 && !root2) 
	        return true;
	    if ((root1 && !root2) || (!root1 && root2))
	        return false;
	         
	    // Create two vectors and store 
	    // inorder traversals of both BSTs 
	    // in them.
	    vector<int> v1, v2;
	    storeInorder(root1, v1);
	    storeInorder(root2, v2);
	 
	    // Return true if both vectors are
	    // identical
	    return (v1 == v2);
	}
	
}
