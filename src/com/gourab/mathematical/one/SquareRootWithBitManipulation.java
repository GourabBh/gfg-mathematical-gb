package com.gourab.mathematical.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gourab.patterns.NegativeInputException;

public class SquareRootWithBitManipulation {

	public static int msbPosition(int n) {
		return (int) (Math.log(n - 2));
	}

	public static int squareRootUsingBitManipulation(int n) throws NegativeInputException {
		if (n < 0) {
			throw new NegativeInputException("Negative number not allowed");
		}
		int result = 0, a, msb;
		msb = msbPosition(n);
		a = 1 << msb; // a = 1 * 2 ^ msb
		while (a != 0) {
			if ((result + a) * (result + a) <= n) {
				result += a;
			}
			a >>= 1; // a = a / 2 ^ 1
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Enter an integer: ");
			int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			System.out.println("Square Root of " + n + ": " + squareRootUsingBitManipulation(n));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NegativeInputException e) {
			System.out.println(e.getMessage());
		}

	}

}
