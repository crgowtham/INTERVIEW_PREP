package com.gowtham;

import java.util.HashMap;

public class TrieAddSearchMap {
	
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("somestring");
		
		System.out.println("somestring: " + trie.search("somestring"));
		System.out.println("somestring: " + trie.startsWith("dome"));
	}

	static  class TrieNode {

		HashMap<Character, TrieNode> map;
		char character;
		boolean last;

		// Initialize your data structure here.
		public TrieNode(char character) {

			this.map = new HashMap<Character, TrieNode>();
			this.character = character;
			this.last = false;

		}

	}

	public static class Trie {

	    private TrieNode root;

	    public Trie() {

	        root = new TrieNode(' ');

	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {

	        TrieNode current = root;
	            
	        for(char c : word.toCharArray()) {
	            
	            if(!current.map.containsKey(c)) {
	                
	                current.map.put(c, new TrieNode(c));
	                
	            }
	            
	            current = current.map.get(c);

	        }
	        
	        current.last = true;
	        
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        
	        TrieNode current = root;
	        
	        for(char c : word.toCharArray()) {
	            
	            if(!current.map.containsKey(c)) return false;
	            
	            current = current.map.get(c);
	            
	        }
	        
	        if(current.last == true) return true;
	        else return false;
	        
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        
	        TrieNode current = root;
	        
	        for(char c : prefix.toCharArray()) {
	            
	            if(!current.map.containsKey(c)) return false;
	            
	            current = current.map.get(c);
	            
	        }
	        
	        return true;
	        
	    }

	}

}
