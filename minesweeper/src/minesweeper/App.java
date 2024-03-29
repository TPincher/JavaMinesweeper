package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String[] acceptedInputs = {"S", "M", "L", "C"};
		String gameStyle;
		int boardHeight = 0;
		int boardWidth = 0;
		char activeLetter;
		int activeNumber;
		int activeTile;


		System.out.println("Welcome, recruit! What's your name?");
		String name = s.nextLine();
		System.out.println("Good to know! We'll put it on the headstone when you kick a mine.");
		System.out.println(name + ", You need to choose what size minefield to clear");
		System.out.println("Enter 'S' for a small grid, 'M' for Medium, 'L' for Large or 'C' to enter a custom size");
		gameStyle = s.nextLine().toUpperCase();
		
		if (!Arrays.asList(acceptedInputs).contains(gameStyle)) {
			do {
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
				System.out.println("A custom size? How many rows do you want? You can choose any number between 4 and 25.");
				boardHeight = Helpers.customSizeValidator();
				System.out.println("And how many columns? Again, any number between 4 and 25.");
				boardWidth = Helpers.customSizeValidator();
				break;
		
		}
		
		
		System.out.println("Alright, then.");	
		int totalTiles = Helpers.boardHelper(boardHeight, boardWidth);
		int totalMines = (int) Math.ceil(totalTiles / 10);	
		System.out.printf("There will be %s tiles and %s mines\n", totalTiles, totalMines);
		Gameboard.makeBlankBoard(boardWidth, boardHeight, totalTiles);
		
		
		System.out.println("Select your starting square - it'll never have a mine on it.\n"
				+ "Choose a square by selecting a letter for a column");
		activeLetter = Helpers.letterInputValidator(boardWidth);
		System.out.println("And now a number for a row.");
		activeNumber = Helpers.numberInputValidator(boardHeight);
		activeTile = (Helpers.convertInputs(activeLetter, activeNumber, boardWidth));
	
	
		Tile[] tileObjectsArray = new Tile[totalTiles];
		for (int i = 0; i <= totalTiles-1; i++) {
			tileObjectsArray[i] = new Tile(i, false, false, false, 0);	
		}
		
		Game.takeTurn(activeTile, tileObjectsArray);
		Game.isGameWon(totalTiles, totalMines);
				
		ArrayList<Integer> mines = Game.setMines(totalMines, totalTiles, activeTile);
				
		for (int i = 0; i < mines.size(); i++) {
		    int activeMine = (mines.get(i));
		    tileObjectsArray[activeMine].setHasMine(true);
		}
		
//      Uncomment the next line for debugging - an array will be displayed showing all mine locations in an array.
//		System.out.println(mines);

		for (int i = 0; i < tileObjectsArray.length; i++) {
		    Tile tile = tileObjectsArray[i];
		    tile.setSurroundingMines(tileObjectsArray, i, boardWidth, totalTiles);
//		    Uncomment the next line to view the entire gameboard for debugging - all tiles will be revealed after turn 2
//		    tile.setOpen(true);
		}
		
		Gameboard.makeBoard(boardWidth, boardHeight, totalTiles, tileObjectsArray);
		
		if (tileObjectsArray[activeTile].getSurroundingMines() == 0) {
			Cascade.callCascade(tileObjectsArray, activeTile, boardWidth, totalTiles);
			Gameboard.makeBoard(boardWidth, boardHeight, totalTiles, tileObjectsArray);
		}
		
		
		Game.setGameActive(true);

		while (Game.isGameActive()) {
			activeLetter = Helpers.letterInputValidator(boardWidth);
			activeNumber = Helpers.numberInputValidator(boardHeight);
			activeTile = (Helpers.convertInputs(activeLetter, activeNumber, boardWidth));
			Game.takeTurn(activeTile, tileObjectsArray);
			if (tileObjectsArray[activeTile].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, activeTile, boardWidth, totalTiles);
			}
			Gameboard.makeBoard(boardWidth, boardHeight, totalTiles, tileObjectsArray);
			Game.isGameWon(totalTiles, totalMines);
		}
		

		s.close();
		Helpers.closeScanner();
		
	}

}
