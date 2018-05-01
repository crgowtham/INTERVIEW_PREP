package com.gowtham;

public class LargestBSTinBT {
	
	// Information to be returned by every
	// node in bottom up traversal.
	class Info
	{
	    int sz; // Size of subtree
	    int max; // Min value in subtree
	    int min; // Max value in subtree
	    int ans; // Size of largest BST which
	    // is subtree of current node
	    boolean isBST; // If subtree is BST
	};
	
	class Node
	{
	    int data;
	    Node left;
	    Node right;
	};
	
	// Returns Information about subtree. The
	// Information also includes size of largest
	// subtree which is a BST.
	Info largestBSTBT(Node root)
	{
	    // Base cases : When tree is empty or it has
	    // one child.
	    if (root == null)
	        return new Info(0, INT_MIN, INT_MAX, 0, true);
	    if (root.left == null && root.right == null)
	        return new Info(1, root.data, root.data, 1, true);
	 
	    // Recur for left subtree and right subtrees
	    Info l = largestBSTBT(root.left);
	    Info r = largestBSTBT(root.right);
	 
	    // Create a return variable and initialize its
	    // size.
	    Info ret;
	    ret.sz = (1 + l.sz + r.sz);
	 
	    // If whole tree rooted under current root is
	    // BST.
	    if (l.isBST && r.isBST && l.max < root.data &&
	            r.min > root.data)
	    {
	        ret.min = min(l.min, min(r.min, root.data));
	        ret.max = max(r.max, max(l.max, root.data));
	 
	        // Update answer for tree rooted under
	        // current 'root'
	        ret.ans = ret.sz;
	        ret.isBST = true;
	 
	        return ret;
	    }
	 
	    // If whole tree is not BST, return maximum
	    // of left and right subtrees
	    ret.ans = max(l.ans, r.ans);
	    ret.isBST = false;
	 
	    return ret;
	}

}
