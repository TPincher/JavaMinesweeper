package minesweeper;

import java.util.Scanner;

public class Helpers {
	
	static Scanner s2 = new Scanner(System.in);

	public static int boardHelper(int a, int b) {
		return a * b;
	}
	
	
    private static int convertColumnInput(char letter) {
        return letter - 'A';
    }
	
    
    public static int convertInputs(char letter, int number, int boardWidth) {
    	int convertedLetter = convertColumnInput(letter);
		return (convertedLetter + ((number -1) * boardWidth));
    }
    
    
    public static char letterInputValidator(int boardWidth) {
    	char letter;
    	
    	letter = s2.next().charAt(0);
    	int convertedLetter = convertColumnInput(letter);
    	if (convertedLetter < 0 || convertedLetter >= boardWidth) {
    		System.out.println("You must choose a valid letter");
    		Helpers.letterInputValidator(boardWidth);
    	}
		return letter;
    }
    
    
    public static int numberInputValidator(int boardHeight) {
    	int number = 0;
   
    	//needs a try/catch block to handle non-numberic input, or repeated incorrect inputs.
		number = s2.nextInt();
    	if (number < 1 || number > boardHeight) {
    		System.out.println("You must choose a valid number");
    		Helpers.numberInputValidator(boardHeight);
    	}
		return number;
    }
    
    //also has the issue of only using the first input. Needs to be fixed.
    public static int customSizeValidator() {
    	int input = 0;
   
    	input = s2.nextInt();
    	if (input < 4 || input > 25) {
    		System.out.println("You must choose a valid number between 4 and 25");
    		Helpers.customSizeValidator();
    	}
		return input;
    }
    

	public static void closeScanner() {
	    s2.close();
	}


}
