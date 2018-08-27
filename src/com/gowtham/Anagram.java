package com.gowtham;
//Given an array of strings, group anagrams together.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:

//[
//["ate", "eat","tea"],
//["nat","tan"],
//["bat"]
//]
//Note: All inputs will be in lower-case.
public class Anagram {
	
	public static void main(String[] args){
		
		String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(test);
		for( List<String> lls:res) {
			for( String ls:lls) {
				System.out.println("anagram :" + ls);
			}
		}
		
	}
	public static List<List<String>> groupAnagrams(String[] strs) {

		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		Arrays.sort(strs);

		for (String s : strs) {

			char[] characters = s.toCharArray();

			Arrays.sort(characters);

			String key = String.valueOf(characters);

			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());

			map.get(key).add(s);

		}

		return new ArrayList<List<String>>(map.values());

	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            Integer mkey = convertint(strs[i]);
            if(!map.containsKey(mkey)) {
                map.put(mkey, new ArrayList<>());
            } 
            map.get(mkey).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
    
    private Integer convertint(String s) {
        char[] sarr = s.toCharArray();
        int[] count = new int[26];
        for(char c : sarr) {
            int num = c - 'a';
            count[num]++;
        }
        
        return Arrays.hashCode(count);
    }
    
    private String convert(String s) {
        char[] sarr = s.toCharArray();
        int[] count = new int[26];
        for(char c : sarr) {
            int num = c - 'a';
            count[num]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : count) {
            sb.append('#').append(i);
        }
        return sb.toString();
    }
}
