package minesweeper;

import java.util.Arrays;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome, recruit! What's your name?");
		String name = s.nextLine();
		System.out.println("Good to know! We'll put it on the headstone when you kick a mine.");
		System.out.println(name + ", You need to choose what size minefield to clear");
		System.out.println("Enter 'S' for a small grid, 'M' for Medium, 'L' for Large or 'C' to enter a custom size");
		
		
		String[] acceptedInputs = {"S", "M", "L", "C"};
		String gameStyle;
		gameStyle = s.nextLine();
		
		if (!Arrays.asList(acceptedInputs).contains(gameStyle)) {do {
			System.out.println("That's not one of the options, recruit!");
			System.out.println("Try again! Enter 'S' for a small grid, 'M' for Medium, 'L' for Large or 'C' to enter a custom size");
			gameStyle = s.nextLine();
			if (Arrays.asList(acceptedInputs).contains(gameStyle))
				break;
		} while (!Arrays.asList(acceptedInputs).contains(gameStyle));
		};
		
		System.out.println("Alright, then.");
		Gameboard.makeBoard(gameStyle);
		
		s.close();
		
	}

}
