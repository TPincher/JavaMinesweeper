package minesweeper;

import java.util.ArrayList;
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
		gameStyle = s.nextLine().toUpperCase();
		int boardHeight = 0;
		int boardWidth = 0;
		
		if (!Arrays.asList(acceptedInputs).contains(gameStyle)) {do {
			System.out.println("That's not one of the options, recruit!");
			System.out.println("Try again! Enter 'S' for a small grid, 'M' for Medium, 'L' for Large or 'C' to enter a custom size");
			gameStyle = s.nextLine();
			if (Arrays.asList(acceptedInputs).contains(gameStyle))
				break;
		} while (!Arrays.asList(acceptedInputs).contains(gameStyle));
		};
		
		switch (gameStyle) {
			case "S":
				boardHeight = 10;
				boardWidth = 10;
				break;
			case "M":
				boardHeight = 15;
				boardWidth = 15;
				break;
			case "L":
				boardHeight = 20;
				boardWidth = 20;
				break;
			case "C":
				System.out.println("A custom size? How many rows do you want? You can choose any number between 5 and 25.");
				boardHeight = s.nextInt();
				System.out.println("And how many columns? Again, any number between 5 and 25.");
				boardWidth = s.nextInt();
				break;
		
		}
		
		
		System.out.println("Alright, then.");
		
		int totalTiles = Helpers.boardHelper(boardHeight, boardWidth);
		int totalMines = (int) Math.ceil(totalTiles / 10);
		char firstLetter;
		int firstNumber;
		int startTile;
		
				
		System.out.printf("There will be %s tiles and %s mines\n", totalTiles, totalMines);
		Gameboard.makeBoardTop(boardWidth);
		Gameboard.blankRow(boardWidth);
		for (int x = 0; x <= boardHeight - 2; x++) {
		Gameboard.makeBoardDivider(boardWidth);
		Gameboard.blankRow(boardWidth);
		}
		Gameboard.makeBoardBottom(boardWidth);
		
		
		System.out.println("Select your starting square - it'll never have a mine on it.\n"
				+ "Choose a square by selecting a letter for a column");
		firstLetter = s.next().charAt(0);
		System.out.println("And now a number for a row.");
		firstNumber = s.nextInt();
		
		startTile = (Helpers.convertInputs(firstLetter, firstNumber, boardHeight));
		System.out.println(startTile);
		
		Tile[] tileObjectsArray = new Tile[totalTiles];
		for (int i = 0; i <= totalTiles-1; i++) {
			tileObjectsArray[i] = new Tile(i, false, false, false, 0);	
		}
				
		ArrayList<Integer> mines = Game.setMines(totalMines, totalTiles, startTile);
				
		for (int i = 0; i < mines.size(); i++) {
		    int activeMine = (mines.get(i));
		    tileObjectsArray[activeMine].setHasMine(true);
		}
		
		System.out.println(mines);
		
//		System.out.println(tileObjectsArray[0].getTileNumber());
//		System.out.println(tileObjectsArray[1].getTileNumber());
//		System.out.println(tileObjectsArray[2].getTileNumber());
//		System.out.println(tileObjectsArray[3].getTileNumber());
//		System.out.println(tileObjectsArray[3].isOpen());
//		tileObjectsArray[3].setOpen(true);
//		System.out.println(tileObjectsArray[3].isOpen());
//		System.out.println(tileObjectsArray[624].getTileNumber());
		
		
		
		
		int tileCheck = s.nextInt();
		Game.takeTurn(tileCheck);
		s.close();
		
	}

}
