package gameProject;

import java.util.*;

public class GFG {
	static String[] board;
	static String turn;
	
	static String checkWinner() {
		String line = null;
		for(int i = 0; i < 8; i++) {
			switch(i) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			
			if (line.equals("XXX")) return "X";
			else if (line.equals("000")) return "0";
		}
		
		//case if there are empty cells
		for(int i = 0; i < 9; i++) {
			if(Arrays.asList(board).contains(
				String.valueOf(i + 1))) {
				System.out.println(turn + "'s turn;");
				System.out.println("Enter a slot number to place " + turn + " in:");
				return null;
			}
		}
		return "draw";
	}
	
	  // To print out the board.
    /* |---|---|---|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |---|---|---|*/
	static void printBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|---|---|---|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		
		for(int i = 0; i < 9; i++) {
			board[i] = "" + (i + 1);
		}
		
		System.out.println("Welcome to tic-tok-toe game!");
		printBoard();
		
		System.out.println("X plays first");
		System.out.println("Enter a slot number to place X in:");
		
		while(winner == null) {
			int numInput;
			
			try {
				numInput = in.nextInt();
				if(numInput < 0 || numInput > 9) {
					System.out.println("Invalid input. Re-enter slot number:");
					continue;
				}
			} catch(Exception e) {
				System.out.println("Invalid input. Re-enter slot number:");
				continue;
			}
			
			if(board[numInput - 1].equals(String.valueOf(numInput))) {
				board[numInput - 1] = turn;
				
				if(turn.equals("X")) turn = "0";
				else turn = "X";
				
				printBoard();
				winner = checkWinner();
				
			} else {
				System.out.println("Slot's already taken. Re-enter slot number:");
			}
		}
		
		if(winner.equals("draw")) {
			System.out.println("It is draw! Thank you for playing!");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing!");
		}
		
		in.close();
	}
}
