package tictatoe;
import java.util.Scanner;

public class run {
	public static void main (String args[]) {
		char board[][]= {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
		boolean gameover=false,repeat;
		char player='X';
		int pos,c=0;
		int[] val= new int[9];
		Scanner sc= new Scanner(System.in);
		System.out.println(" TIC TAC TOE");
		printboard(board);
		System.out.println();
		
		while(gameover==false) {
			repeat=false;
			System.out.println("\nIt's "+player+"'s turn , enter the position");
			pos=sc.nextInt();
			for(int i=0;i<val.length;i++) {
				if(val[i]==pos) {
					repeat=true;
					break;
				}
			}
			if(!repeat && pos<10) {	
			val[c++]=pos;
			switch(pos) {
			case 1: board[0][0]=player; break;		
			case 2: board[0][1]=player; break;	
			case 3: board[0][2]=player; break;	
			case 4: board[1][0]=player; break;	
			case 5: board[1][1]=player; break;	
			case 6: board[1][2]=player; break;	
			case 7: board[2][0]=player; break;	
			case 8: board[2][1]=player; break;	
			case 9: board[2][2]=player; break;
			default: System.out.println("\nInavlid Option!! Try Again");
			}
			printboard(board);
			System.out.println();
			gameover=haswon(board,player);
			if(gameover) {
				System.out.println(player+" has Won !!");
			}
			else {
				player=(player=='X')? 'O' : 'X';
			}
			}
			else
				System.out.println("\nInavlid Option!! Try Again");
			if(c==9) {
				System.out.println("\nMatch Tied !!");
				break;
			}
			
			
		}
		sc.close();
		
	}
	public static boolean haswon(char[][] board,char player) {
		for(int i=0;i<3;i++) {
		if((board[i][0] == player) && (board[i][1] == player) && (board[i][2] == player))
				return true;
		}
		for(int i=0;i<3;i++) {
		if((board[0][i] == player) && (board[1][i] == player) && (board[2][i] == player))
				return true;
		}
		if((board[0][0]==player)&&(board[1][1]==player)&&(board[2][2]==player))
			return true;
		if((board[0][2]==player)&&(board[1][1]==player)&&(board[2][0]==player))
			return true;
		
		return false;
		
	}
	public static void printboard(char[][] board) {
		System.out.println("___ ___ ___");
		for(int row=0;row<board.length;row++) {
			System.out.println("   |   |   |");
			for(int col=0;col<board.length;col++) {
				System.out.print(" "+board[row][col]+" |");
			}
			System.out.println();
			System.out.println("___|___|___|");
		}

	}

}
