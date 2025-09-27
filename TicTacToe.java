package com.projects;

import java.util.Scanner;

public class TicTacToe {

	static Scanner sc=new Scanner(System.in);
	static char[][] charArray= {{' ',' ',' '},
			                    {' ',' ',' '},
	                            {' ',' ',' '}};
	
	static char player='X';
	
	public static void main(String[] args) {
		
		boolean status=true;
		while(status) {
			board(charArray);
			System.out.println();
			System.out.println(player+" Select your row(0-2):");
			int row=sc.nextInt();
			System.out.println(player +" Select your column(0-2):");
			int col=sc.nextInt();
			
			if(isValid(row,col)) {
				charArray[row][col]=player;
				if(isWinning()) {
					board(charArray);
					System.out.println("Player "+ player +" win the match!!!");
					break;
				}
				if(isDraw()) {
					board(charArray);
					System.out.println("Match is Drawn!!!");
					break;
				}
				player=player=='X'?'O':'X';
				
			}else {
				System.out.println("InValid Selection!!!");
				continue;
			}
		}
	}
	static void board(char[][] charArray) {
		
		for(int i=0;i<3;i++) {
			System.out.println("-----------------");
			for(int j=0;j<3;j++) {
				System.out.print("|  "+charArray[i][j]+" ");
			}
			System.out.println("|");
		}
		System.out.print("-----------------");
		System.out.println();
	}
	
	static boolean isValid(int row, int col) {
		if(row>2 || col>2 || row<0 || col<0 ||charArray[row][col]!=' ') {
			return false;
		}
		return true;
	}
	static boolean isWinning() {
		for(int i=0;i<3;i++) {
			if(charArray[i][0]==player && charArray[i][1]==player && charArray[i][2]==player) {
				return true;
			}
			if(charArray[0][i]==player && charArray[1][i]==player && charArray[2][i]==player) {
				return true;
			}
		}
		if((charArray[0][0]==player && charArray[1][1]==player && charArray[2][2]==player) 
				|| (charArray[0][2] ==player && charArray[1][1]==player && charArray[2][0]==player)) {
			return true;
		}
		return false;
	}
	
	static boolean isDraw() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(charArray[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
}
