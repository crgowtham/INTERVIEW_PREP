package com.gowtham;

import java.util.*;

public class ConvertBinaryTreeToBST {
	class Node
	{
	    int data;
	    Node left;
	    Node right;
	};

	Vector vec = new Vector(10);


	void orderGo(Node root) {
	     if(root!=null) {
	        vec.add(root.data);
	        orderGo(root.left);
	        orderGo(root.right);
	     }
	}

	void inorder(Node root){
	    if(root.left != null) inorder(root.left);
	    root.data = vec.get(0);
	    vec.erase(vec.begin());
	    if(root.right != null) inorder(root.right);
	}

	/*Your code here*/
	Node binaryTreeToBST (Node root)
	{
	    orderGo(root);
	    sort(vec.begin(), vec.end());
	    inorder(root);
	   return root;
	}

}
