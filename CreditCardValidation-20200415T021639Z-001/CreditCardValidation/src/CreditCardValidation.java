import java.util.Scanner;

public class CreditCardValidation {
	//Function to convert String input to a integer array
	public static int[] convertToInt(String cardNumber) {
		// Local Variables
		int index = getSize(cardNumber);
		int[] cardNumberInt = new int[index];
		// Loop to convert chars to integer
		for (int i = 0; i < index; i++) {
			char number = cardNumber.charAt(i);
			cardNumberInt[i] = (int) number - 48;
		}
		return cardNumberInt;
	}
	//Function to determine if the card number is valid
	public static boolean isValid(int number) {
		boolean valid;
		if (number % 10 == 0)
			valid = true;
		else
			valid = false;
		return valid;
	}
	//Function to sum the even indexed numbers multiplied by 2 
	public static int sumOfDoubleEvenPlace(int[] cardNumberInt) {
		int sumOfEven = 0, check = 0;
		for (int i = 0; i < cardNumberInt.length; i += 2) {
			
			//If double digit call to cardNumberInt 
			if (cardNumberInt[i] >= 5) {
				check = cardNumberInt[i];
				sumOfEven += getDigit(check);
			} else
				sumOfEven += cardNumberInt[i] * 2;
		}

		return sumOfEven;
	}
	//If the multiple of if the even digits are double digits
	public static int getDigit(int number) {
		String numberString = Integer.toString(number * 2);
		char num = numberString.charAt(0);
		char num2 = numberString.charAt(1);
		number = ((int) num - 48) + ((int) num2 - 48);

		return number;
	}
	//Function to sum up the odd indexed elements
	public static int sumOfOddPlace(int[] cardNumberInt) {
		int sumOfOdd = 0;
		for (int i = 1; i < cardNumberInt.length; i += 2) {
			sumOfOdd += cardNumberInt[i];
		}
		return sumOfOdd;
	}
	//Function to return the number of elements in the credit card.
	public static int getSize(String cardNumber) {
		int index;
		index = cardNumber.length();
		return index;
	}
	//Function to evaluate prefix and return credit card type
	public static String getPrefix(String cardNumber) {
		char number = cardNumber.charAt(0);
		int num = (int) number - 48;
		String cardType = "";
		switch (num) {
		case 3:
			if ((int) cardNumber.charAt(1) - 48 == 7)
				cardType = "American Express";
			else
				cardType = "Invalid";
			break;
		case 4:
			cardType = "Visa card";
			break;
		case 5:
			cardType = "Master Card";
			break;
		case 6:
			cardType = "Discover card";
			break;
		default:
			cardType = "Invalid";
			break;
		}
		return cardType;
	}

	public static void main(String[] args) {
		
		// Variable
		int odd, even,size;
		int[] cardNumberInt;
		String cardType;
		boolean valid = true;
		Scanner input = new Scanner(System.in);
		
		//Prompt for card number
		System.out.print("Enter Crdit Card Number");
		String cardNumber = input.next();
		
		//Call to prefix function
		cardType = getPrefix(cardNumber);
		
		//Call to get number of digits
		size = getSize(cardNumber);
		
		//Evaluate if the card has a valid prefix and if there are enough digits
		if (!cardType.equals("Invalid") && size >= 13 && size <= 16) {
			
			//Call to convert string to digits
			cardNumberInt = convertToInt(cardNumber);
			//Call to sum of even numbers
			even = sumOfDoubleEvenPlace(cardNumberInt);
			//Call to sum of odd numbers 
			odd = sumOfOddPlace(cardNumberInt);
			//Call to calculated validity 
			valid = isValid(even + odd);
		}
		else{
			valid = false;
		}
		
		//Display out come
		if(valid){
			System.out.print("The card number " + cardNumber + " is a valid " + cardType);
		}
		else
			System.out.print("The card number " + cardNumber + " is invalid.");
			

	}

}
