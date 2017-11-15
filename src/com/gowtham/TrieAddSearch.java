package com.gowtham;

public class TrieAddSearch {

	public static void main(String[] args) {
		addWord("bad");
		addWord("dad");
		addWord("mad");
		System.out.println("pad : " + search("pad") ); //-> false
		System.out.println("bad : " + search("bad") ); //- -> true
		System.out.println(".ad : " + search(".ad") ); //- -> true
		// search(".ad") -> true
		// search("b..") -> true

	}

	public static class TrieNode {

		public TrieNode[] children = new TrieNode[26];
		public String item = "";

	}

	private static TrieNode root = new TrieNode();

	public static void addWord(String word) {
		TrieNode node = root;

		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			} 
				node = node.children[c - 'a'];
		}

		node.item = word;
	}

	public static boolean search(String word) {

		return match(word.toCharArray(), 0, root);

	}

	private static boolean match(char[] chs, int k, TrieNode node) {
    	if(k == chs.length) return !node.item.equals("");
    	
    	if (chs[k] != '.') {
    		return node.children[chs[k] - 'a'] != null && match(chs, k+1, node.children[chs[k] - 'a']);
    	} else {
    		for (int i = 0; i < node.children.length; i++) {
    			if(node.children[i] != null) {
    				if(match(chs, k+1, node.children[i]))
    					return true;
    			}
    		}
    	} 
    		return false;
    		
    }

}
