package com.gourab.mathematical.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.gourab.patterns.NegativeInputException;

public class NisKthRootOfNumber {

	class ReturnVal {
		private Boolean result;
		private Integer number;

		public ReturnVal(Boolean result, Integer number) {
			this.result = result;
			this.number = number;
		}

		public Boolean getResult() {
			return result;
		}

		public void setResult(Boolean result) {
			this.result = result;
		}

		public Integer getNumber() {
			return number;
		}

		public void setNumber(Integer number) {
			this.number = number;
		}

	}

	public ReturnVal kthRoot(Integer n, Integer k) {
		if (k == 0) {
			if (n == 1) {
				return new ReturnVal(true, (int) (10 * Math.random()));
			}
			return new ReturnVal(false, 0);
		} else {
			double reciprocal = (double) 1 / (double) k;
			double power = Math.pow(n, reciprocal);
			if (Math.floor(power) == Math.ceil(power)) {
				return new ReturnVal(true, (int) Math.floor(power));
			}
			return new ReturnVal(false, (int) Math.floor(power));
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("Enter n and k: ");
			int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			if (n < 0) {
				throw new NegativeInputException("Please provide +ve N");
			}
			int k = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			NisKthRootOfNumber nisKthRootOfNumber = new NisKthRootOfNumber();
			if (k == 0 && n == 1) {
				System.out.println("Any number, say " + nisKthRootOfNumber.kthRoot(n, k).getNumber()
						+ " to the power of " + k + " is " + n);
			}
			System.out.println(n + " is " + k + "th power of " + nisKthRootOfNumber.kthRoot(n, k).getNumber() + "? --> "
					+ nisKthRootOfNumber.kthRoot(n, k).getResult());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NegativeInputException e) {
			System.out.println(e.getMessage());
		}
	}
}
