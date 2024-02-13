package minesweeper;


public class Helpers {

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
}
