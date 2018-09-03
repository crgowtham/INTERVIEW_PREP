package com.gowtham;

import java.util.HashMap;

//Implement a trie with insert, search, and startsWith methods.

//Note:
//You may assume that all inputs are consist of lowercase letters a-z.

//Your Trie object will be instantiated and called as such:
//Trie trie = new Trie();
//trie.insert("somestring");
//trie.search("key");

public class Trie {

	class TrieNode {
		public char val;
		public boolean isWord;
		public TrieNode[] children = new TrieNode[26];

		public TrieNode() {
		}

		TrieNode(char c) {
			TrieNode node = new TrieNode();
			node.val = c;
		}
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
		root.val = ' ';
	}

	public void insert(String word) {
		TrieNode ws = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (ws.children[c - 'a'] == null) {
				ws.children[c - 'a'] = new TrieNode(c);
			}
			ws = ws.children[c - 'a'];
		}
		ws.isWord = true;
	}

	public boolean search(String word) {
		TrieNode ws = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (ws.children[c - 'a'] == null)
				return false;
			ws = ws.children[c - 'a'];
		}
		return ws.isWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode ws = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (ws.children[c - 'a'] == null)
				return false;
			ws = ws.children[c - 'a'];
		}
		return true;
	}

}
