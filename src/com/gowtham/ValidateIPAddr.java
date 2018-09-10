package com.gowtham;

public class ValidateIPAddr {

	/*
	 * Input: "172.16.254.1"
	 * 
	 * Output: "IPv4"
	 * 
	 * Explanation: This is a valid IPv4 address, return "IPv4". Example 2:
	 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
	 * 
	 * Output: "IPv6"
	 * 
	 * Explanation: This is a valid IPv6 address, return "IPv6". Example 3:
	 * Input: "256.256.256.256"
	 * 
	 * Output: "Neither"
	 * 
	 * Explanation: This is neither a IPv4 address nor a IPv6 address.
	 */

	public String validIPAddress(String IP) {
		if (IP.matches(
				"(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))
			return "IPv4";
		if (IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))
			return "IPv6";
		return "Neither";
	}
}
