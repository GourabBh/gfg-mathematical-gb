package com.gourab.mathematical.one;

public class MaxCellsAttackedByRookOrBishop {
	
	public static int maxCellsAttackCompetition(int n, int posRook, int posBishop) {
		int totalCellsAttackedByRook = 2 * (n - 1);
		int totalCellsAttackedByBishop = min(posRook - 1, posBishop - 1) +
				min(n - posRook, n - posBishop) + min(n - posRook, posBishop - 1) + min(n - posBishop, posRook - 1);
		if(totalCellsAttackedByBishop > totalCellsAttackedByRook) {
			return 1;
		}
		else if(totalCellsAttackedByRook > totalCellsAttackedByBishop) {
			return -1;
		}
		return 0;
	}
	
	public static int min(int a, int b) {
		if(a < b) {
			return a;
		}
		return b;
	}
	
	public static void main(String[] args) {
		int result = maxCellsAttackCompetition(3, 2, 1);
		if(result == 0) {
			System.out.println("Both have same number of attacking cells!");
		}
		else if(result == -1) {
			System.out.println("Rook has more number of attacking cells!");
		}
		else {
			System.out.println("Bishop has more number of attacking cells!");
		}
	}
}
