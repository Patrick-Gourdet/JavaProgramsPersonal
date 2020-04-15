import java.util.Scanner;


public class ConnectFour {
	private final char player1_R = 'R';
	private final char player2_W = 'W';
	private final char empty = ' ';
	final int row = 6;
	final int column = 7;
	final int lowerBound = 0;
	int moves = 0;
	boolean player1 = true;
	char[][] playerMoves = new char[row][column];
	
	//Print playing board with entered values
	public void printBoard() {
		
		for (int i = 0; i < this.row; i++){
			for (int j = 0; j < this.column; j++) {
				System.out.print("| " + playerMoves[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("-----------------------------");
	}
	//Get input from player
	public boolean getPlayerEntry() {
		Scanner input = new Scanner(System.in);
		boolean continuePlaying;
		int row, column;
		if (player1) {
			System.out
					.print("Player Red enter (1-7) to drop chip:");
			column = input.nextInt();
			//Function call to drop chip in column
			row = dropChip(column - 1);
				
			playerMoves[row][column - 1] = player1_R;
			continuePlaying = checkWhoWon(row, column - 1, player1_R);
			
			player1 = false;
		} else {
			System.out
					.print("Player White enter (1-7) to drop chip:");
			column = input.nextInt();
			//Function call to drop chip in column
			row = dropChip(column - 1);		
			playerMoves[row][column - 1] = player2_W;
			continuePlaying = checkWhoWon(row, column - 1, player2_W);
			player1 = true;
		}
		return continuePlaying;
	}
	//Function call to find last unoccupied column
	public int dropChip(int column) {
		boolean played = false;
		int i = 0,row = 0;
		while( i < this.row-1){
			if(playerMoves[i+1][column] == ' ')
				row++;
				++i;
		}
		return row;
	}
	//Check if a player has four chips in a row
	public boolean checkWhoWon(int row, int column, char entry) {
		boolean continuePlaying = true;
		int fourInRow = 0;
		
		// Check along the current row
		if(column + 3 <= this.column-1){
		for (int i = column; i <= this.column-1; i++) {
			if (playerMoves[row][i] == entry)
				fourInRow++;
			else
				break;
		}
		}
		continuePlaying = fourInARow(fourInRow, continuePlaying);
		fourInRow = 0;
		if(column - 3 >= this.lowerBound){
			for (int i = column; i >= this.lowerBound; i--) {
				if (playerMoves[row][i] == entry)
					fourInRow++;
				else
					break;
			}
			}
		// Created function to replace if statement to see who won
		continuePlaying = fourInARow(fourInRow, continuePlaying);
		fourInRow = 0;
		// Check along column
		if((row + 3) <= (this.row-1)){		
		for (int i = row+3; i >= row; i--) {
			if (playerMoves[i][column] == entry)
				fourInRow++;
			else
				break;
		}
		}
		continuePlaying = fourInARow(fourInRow, continuePlaying);
		fourInRow = 0;
		// Check the diagonal entries left to right
		if((row + 3) <= (this.row-1) && column + 4 <= this.column-1) {
			for (int i = row,j=column; i <= this.row-1 && j <= this.column-1; i++,j++) {
				if (playerMoves[i][j] == entry)
					fourInRow++;
				else
					break;
			}
		}
		continuePlaying = fourInARow(fourInRow, continuePlaying);
		fourInRow = 0;
		// Check the diagonal entries right to left
		if ((row + 3) <= (this.row-1)&& column - 4 >= this.lowerBound) {
			for (int i = 0, j = column; i > 0; i--, j--) {
				if (playerMoves[i][j] == entry)
					fourInRow++;
				else
					break;
			}
		}
		continuePlaying = fourInARow(fourInRow, continuePlaying);
		// If someone one display who won
		if (!continuePlaying) {
			System.out.println(entry + "'s WIN !!!!!!!!!!!!!!");
		}
		return continuePlaying;
	}
	public boolean fourInARow(int fourInRow, boolean continuePlaying) {

		if (fourInRow == 4)
			continuePlaying = false;
		return continuePlaying;
	}
	//Set matrix fields to ' '
	public char[][] setMatrix() {

		char[][] playerMoves = new char[this.row][this.column];
		for (int i = 0; i < this.row; i++) {
			for (int j = 0; j < this.column; j++) {
				playerMoves[i][j] = this.empty;
			}
		}
		return playerMoves;
	}
	
	//Call all other functions
	public void getSetMatrix() {
		boolean continuePlaying = true;
		playerMoves = setMatrix();
		printBoard();
		while (continuePlaying) {
			moves++;
			continuePlaying = getPlayerEntry();
			// If no more moves declare the game a draw
			if (moves == 42) {
				System.out.println("ITS A DRAW");
				continuePlaying = false;
			}
			printBoard();
		}
	}
	public static void main(String[] args) {
		ConnectFour cf = new ConnectFour();
		cf.getSetMatrix();

	}

}
