package chess;

import java.util.Scanner;

public class Chess {
	private static String[][] board;
	private static char r1, r2, sp, c1, c2;
	
	public static void main(String[] args) {
		setChessBoard();
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++)
			{
				if(j==8) {
					System.out.println(board[i][j]);
				}
				else {
					System.out.print(board[i][j] + " ");
				}
			}
		}
		
		System.out.println();
		
		String input = null, hold = null, temp = null;
		Scanner scan = new Scanner(System.in);
		boolean check = false;
		
		while(input != "end") {
			while(check != true) {
				System.out.print("White's move: ");
				input = scan.nextLine();
			
				if(input.equals("end")) {
					break;
				}
				
				setChars(input);
				check = checkInput();
			}
			
			if(input.equals("end")) {
				break;
			}
			
			check = false;
			hold = "Illegal move, try again";
			
			while(hold.equals("Illegal move, try again")) {
				if(board[rowNumber(r1)][colNumber(c1)].equals("wp")) {
					hold = whitePawn();
				}
				
				if(hold.equals("move")) {
					temp = board[rowNumber(r1)][colNumber(c1)];
					board[rowNumber(r1)][colNumber(c1)] = board[rowNumber(r2)][colNumber(c2)];
					board[rowNumber(r2)][colNumber(c2)] = temp;
				}
				else if(hold.equals("attack")) {
					board[rowNumber(r2)][colNumber(c2)] = board[rowNumber(r1)][colNumber(c1)];
					board[rowNumber(r1)][colNumber(c1)] = "  ";
				}
				else {
					System.out.println();
					System.out.println(hold);
	
					while(check != true) {
						System.out.println();
						System.out.print("White's move: ");
						input = scan.nextLine();
					
						if(input.equals("end")) {
							break;
						}
						
						setChars(input);
						check = checkInput();
					}
				}
				
				check = false;
				
				if(input.equals("end")) {
					break;
				}
			}
			
			
			System.out.println();
				
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[i].length; j++)
				{
					if(j==8) {
						System.out.println(board[i][j]);
					}
					else {
						System.out.print(board[i][j] + " ");
					}
				}
			}
			
			System.out.println();
			
			while(check != true) {
				System.out.print("Black's move: ");
				input = scan.nextLine();
			
				if(input.equals("end")) {
					break;
				}
				
				setChars(input);
				check = checkInput();
			}
			
			if(input.equals("end")) {
				break;
			}
			
			check = false;
			hold = "Illegal move, try again";
			
			while(hold.equals("Illegal move, try again")) {
				if(board[rowNumber(r1)][colNumber(c1)].equals("bp")) {
					hold = blackPawn();
				}
				
				if(hold.equals("move")) {
					temp = board[rowNumber(r1)][colNumber(c1)];
					board[rowNumber(r1)][colNumber(c1)] = board[rowNumber(r2)][colNumber(c2)];
					board[rowNumber(r2)][colNumber(c2)] = temp;
				}
				else if(hold.equals("attack")) {
					board[rowNumber(r2)][colNumber(c2)] = board[rowNumber(r1)][colNumber(c1)];
					board[rowNumber(r1)][colNumber(c1)] = "  ";
				}
				else {
					System.out.println();
					System.out.println(hold);
					
					while(check != true) {
						System.out.println();
						System.out.print("Black's move: ");
						input = scan.nextLine();
					
						if(input.equals("end")) {
							break;
						}
						
						setChars(input);
						check = checkInput();
					}
					
					check = false;
					
					if(input.equals("end")) {
						break;
					}
				}
			}
			
			System.out.println();
			
			for(int i=0; i<board.length; i++) {
				for(int j=0; j<board[i].length; j++)
				{
					if(j==8) {
						System.out.println(board[i][j]);
					}
					else {
						System.out.print(board[i][j] + " ");
					}
				}
			}
			
			System.out.println();
		}
	}
	
	public static String whiteRook() {
		if(c1 == c2) {
			if(r2 - r1 > 0) {
				for(int i = Character.digit(r1, 10); i <= Character.digit(r2, 10); i++ ){
					if(board[i+rowNumber(r2)][colNumber(c2)] == "  " || board[i+rowNumber(r2)][colNumber(c2)] == "##") {
						
					}
				}
			}
		}
	}
	
	public static String blackPawn() {
		if(c1 == c2) {
			if(r1 == '7' && r2 == '5' && (board[rowNumber(r2)-1][colNumber(c2)] == "  " || board[rowNumber(r2)-1][colNumber(c2)] == "##" && (board[rowNumber(r2)][colNumber(c2)] == "  " || board[rowNumber(r2)][colNumber(c2)] == "##"))) {
				return "move";
			}
			else if(r1 - r2 == 1 && (board[rowNumber(r2)][colNumber(c2)] == "  " || board[rowNumber(r2)][colNumber(c2)] == "##")) {
				return "move";
			}
		}
		else if((c1 - c2 == 1 || c1 - c2 == -1) && r1 - r2 == 1 && (board[rowNumber(r2)][colNumber(c2)] != "  " || board[rowNumber(r2)][colNumber(c2)] != "##"))  {
			return "attack";
		}
		
		return "Illegal move, try again";
	}
	
	public static String whitePawn() {
		if(c1 == c2) {
			if(r1 == '2' && r2 == '4' && (board[rowNumber(r2)+1][colNumber(c2)] == "  " || board[rowNumber(r2)+1][colNumber(c2)] == "##" && (board[rowNumber(r2)][colNumber(c2)] == "  " || board[rowNumber(r2)][colNumber(c2)] == "##"))) {
				return "move";
			}
			else if(r2 - r1 == 1 && (board[rowNumber(r2)][colNumber(c2)] == "  " || board[rowNumber(r2)][colNumber(c2)] == "##")) {
				return "move";
			}
		}
		else if((c1 - c2 == 1 || c1 - c2 == -1) && r2 - r1 == 1 && (board[rowNumber(r2)][colNumber(c2)] != "  " || board[rowNumber(r2)][colNumber(c2)] != "##"))  {
			return "attack";
		}
		
		return "Illegal move, try again";
	}
	
	public static boolean checkInput() {
		if(c1 < 'a' || c1 > 'h' || c2 < 'a' || c2 > 'h') {
			return false;
		}
		else if(r1 < '1' || r1 > '8' || r2 < '1' || r2 > '8') {
			return false;
		}
		else if(sp != ' ') {
			return false;
		}
		
		return true;
	}
	
	public static void setChars(String s) {
		s.toLowerCase();
		
		c1 = s.charAt(0);
		r1 = s.charAt(1);
		sp = s.charAt(2);
		c2 = s.charAt(3);
		r2 = s.charAt(4);	
	}
	
	public static int colNumber(char c) {
		switch(c) {
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			case 'g':
				return 6;
			case 'h':
				return 7;
			default:
				return -1;
		}
	}
	
	public static int rowNumber(char c) {
		switch(c) {
			case '8':
				return 0;
			case '7':
				return 1;
			case '6':
				return 2;
			case '5':
				return 3;
			case '4':
				return 4;
			case '3':
				return 5;
			case '2':
				return 6;
			case '1':
				return 7;
			default:
				return -1;
		}
	}
	
	public static void setChessBoard() {
		board = new String[9][9];
		
		board[0][0] = "bR";
		board[0][1] = "bN";
		board[0][2] = "bB";
		board[0][3] = "bQ";
		board[0][4] = "bK";
		board[0][5] = "bB";
		board[0][6] = "bN";
		board[0][7] = "bR";
		board[0][8] = "8";
		board[1][0] = "bp";
		board[1][1] = "bp";
		board[1][2] = "bp";
		board[1][3] = "bp";
		board[1][4] = "bp";
		board[1][5] = "bp";
		board[1][6] = "bp";
		board[1][7] = "bp";
		board[1][8] = "7";
		board[2][0] = "  ";
		board[2][1] = "##";
		board[2][2] = "  ";
		board[2][3] = "##";
		board[2][4] = "  ";
		board[2][5] = "##";
		board[2][6] = "  ";
		board[2][7] = "##";
		board[2][8] = "6";
		board[3][0] = "##";
		board[3][1] = "  ";
		board[3][2] = "##";
		board[3][3] = "  ";
		board[3][4] = "##";
		board[3][5] = "  ";
		board[3][6] = "##";
		board[3][7] = "  ";
		board[3][8] = "5";
		board[4][0] = "  ";
		board[4][1] = "##";
		board[4][2] = "  ";
		board[4][3] = "##";
		board[4][4] = "  ";
		board[4][5] = "##";
		board[4][6] = "  ";
		board[4][7] = "##";
		board[4][8] = "4";
		board[5][0] = "##";
		board[5][1] = "  ";
		board[5][2] = "##";
		board[5][3] = "  ";
		board[5][4] = "##";
		board[5][5] = "  ";
		board[5][6] = "##";
		board[5][7] = "  ";
		board[5][8] = "3";
		board[6][0] = "wp";
		board[6][1] = "wp";
		board[6][2] = "wp";
		board[6][3] = "wp";
		board[6][4] = "wp";
		board[6][5] = "wp";
		board[6][6] = "wp";
		board[6][7] = "wp";
		board[6][8] = "2";
		board[7][0] = "wR";
		board[7][1] = "wN";
		board[7][2] = "wB";
		board[7][3] = "wQ";
		board[7][4] = "wK";
		board[7][5] = "wB";
		board[7][6] = "wN";
		board[7][7] = "wR";
		board[7][8] = "1";
		board[8][0] = " a";
		board[8][1] = " b";
		board[8][2] = " c";
		board[8][3] = " d";
		board[8][4] = " e";
		board[8][5] = " f";
		board[8][6] = " g";
		board[8][7] = " h";
		board[8][8] = " ";
	}
}
