import java.util.Scanner;


public class RockPaperSissors {
	public static void main(String[] args) {
		// Variables
		final int minimum =0,maximum = 3;
		int computerOutcome,player;
		String message = "";
		Scanner input = new Scanner(System.in);
		
		//Generate computer choice 		
		computerOutcome = minimum + (int)(Math.random()*maximum);
		//Prompt player for choice
		System.out.print("Enter choice Rock(0) Paper(1) Scissor(2):");
		player = input.nextInt();
		input.close();
		

		// if the out come is a draw		
		if(computerOutcome == player)
			computerOutcome = 3;
		// checks if player entered a valid number or 		
		else if(player < 0 || player > 2)
			computerOutcome = 4;
		
		//Case and nested if else to evaluate message
		switch(computerOutcome){
		case 0:if(player == 1)
					message = "The computer  chose Rock you chose Paper you win";
				else
					message = "The computer  chose Rock you chose Scissor you loose";
				break;
		case 1:if(player == 2)
					message = "The computer  chose Paper you chose Scissor you win";
				else
					message = "The computer  chose Paper you chose Rock you loose";
				break;
		case 2:if(player == 0)
					message = "The computer  chose Scissor you chose Rock you win";
				else
					message = "The computer  chose Scissor you chose Paper you loose";
				break;
		case 3:
				if(player == 0)
					message = "The computer and you chose Rock its a draw";
				else if(player == 1)
					message = "The computer and you chose Paper its a draw";
				else
					message = "The computer and you chose Scissor its a draw";
				break;
		default :
				message = "You enterd an in valid choice exiting program";
		}
		
		//Display outcome
			System.out.println(message);

	}

}
