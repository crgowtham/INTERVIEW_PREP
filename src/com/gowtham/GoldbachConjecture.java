package com.gowtham;

/*
 * Goldbach’s conjecture – Every even integer greater than 2 can be represented as the sum of two primes numbers.

Example:

Given Number : 200

Prime Numbers are 3 197
Prime Numbers are 7 193
Prime Numbers are 19 181
Prime Numbers are 37 163
Prime Numbers are 43 157
Prime Numbers are 61 139
Prime Numbers are 73 127
Prime Numbers are 97 103*/
public class GoldbachConjecture {

	public static void Goldbach(int x) {
		if (x % 2 != 0) {
			System.out.println("Not Even");
			return;
		}
		if (x <= 2) {
			System.out.println("Less than 2");
			return;
		}
		for (int i = 3; i < x / 2; i++) {
			if (isPrime(i) && isPrime(x - i)) {
				System.out.println("Prime Numbers are " + i + " " + (x - i));
			}
		}
	}

	public static boolean isPrime(int x) {
		for (int i = 2; i < x / 2; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Goldbach(100);

	}

}