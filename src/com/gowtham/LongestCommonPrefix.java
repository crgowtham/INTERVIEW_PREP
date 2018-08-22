package com.gowtham;

public class LongestCommonPrefix {
	
	/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
	 */


	public String longestCommonPrefix(String[] strs) {
	        StringBuilder result = new StringBuilder();
	        
	        if (strs!= null && strs.length > 0){
	        
	            Arrays.sort(strs);
	            
	            char [] a = strs[0].toCharArray();
	            char [] b = strs[strs.length-1].toCharArray();
	            
	            for (int i = 0; i < a.length; i ++){
	                if (b.length > i && b[i] == a[i]){
	                    result.append(b[i]);
	                }
	                else {
	                    return result.toString();
	                }
	            }
	        return result.toString();
	    }

}
