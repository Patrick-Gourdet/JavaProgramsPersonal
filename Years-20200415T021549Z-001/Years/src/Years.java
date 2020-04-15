import java.util.*;


public class Years {

	public static void main(String[] args) {
		
		//Variables
		final int HOUR = 60,DAY = 24,YEAR = 365;
		int minutes;
		Scanner input = new Scanner(System.in);
		
		//Prompt and enter minutes
		System.out.print("Please enter a number > 0 for minutes:");
		minutes = input.nextInt();
		
		//Close Scanner object
		input.close();
		
		//Input verification if else block producing out put according to values entered
		if(minutes <= 0){
			
			//Display message if invalid value 
			System.out.println("You entered an invalid value");
			System.exit(0);
		}else if(minutes < 60){
			
			//Display minutes
			System.out.println("You entered " + minutes + " minutes");
			System.exit(0);
		}else if(minutes < 1440){
			
			//Calculate and display hours and minutes
			System.out.println("The minutes are equal to " + minutes / HOUR + " hours and " +
					minutes % HOUR + " minutes");
			System.exit(0);
		}else{
			
			//Display original minutes entered 
			System.out.print(minutes + " minutes is ");
			
			//Calculate years days hours and left over minutes and display them
			System.out.println((minutes / (HOUR * DAY * YEAR)) + " Years " + 
			(minutes % (HOUR * DAY * YEAR))/(HOUR*DAY) +  " Days " + 
					((minutes % (HOUR * DAY * YEAR))%(HOUR*DAY))/HOUR +
					" Hours " + ((minutes % (HOUR * DAY * YEAR))%(HOUR*DAY))%HOUR + " Minutes");
					
		}
					
	}

}
