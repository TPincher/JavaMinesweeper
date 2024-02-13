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
		char activeLetter;
		int activeNumber;
		int activeTile;
		
				
		System.out.printf("There will be %s tiles and %s mines\n", totalTiles, totalMines);
		Gameboard.makeBlankBoard(boardWidth, boardHeight, totalTiles);
		
		
		System.out.println("Select your starting square - it'll never have a mine on it.\n"
				+ "Choose a square by selecting a letter for a column");
		activeLetter = s.next().charAt(0);
		System.out.println("And now a number for a row.");
		activeNumber = s.nextInt();
		
		activeTile = (Helpers.convertInputs(activeLetter, activeNumber, boardWidth));
		
		Tile[] tileObjectsArray = new Tile[totalTiles];
		for (int i = 0; i <= totalTiles-1; i++) {
			tileObjectsArray[i] = new Tile(i, false, false, false, 0);	
		}
		
		Game.takeTurn(activeTile, tileObjectsArray);

				
		ArrayList<Integer> mines = Game.setMines(totalMines, totalTiles, activeTile);
				
		for (int i = 0; i < mines.size(); i++) {
		    int activeMine = (mines.get(i));
		    tileObjectsArray[activeMine].setHasMine(true);
		}
		
//      Uncomment the next line for debugging - an array will be displayed showing all the mines
//		System.out.println(mines);

		for (int i = 0; i < tileObjectsArray.length; i++) {
		    Tile tile = tileObjectsArray[i];
		    tile.setSurroundingMines(tileObjectsArray, i, boardWidth, totalTiles);
//		    Uncomment the next line to view the entire gameboard for debugging - all tiles will be revealed after turn 2
//		    tile.setOpen(true);
		}
		
		Gameboard.makeBoard(boardWidth, boardHeight, totalTiles, tileObjectsArray);
		
		Game.setGameActive(true);
		
		while (Game.isGameActive()) {
			activeLetter = s.next().charAt(0);
			activeNumber = s.nextInt();
			activeTile = (Helpers.convertInputs(activeLetter, activeNumber, boardWidth));
			Game.takeTurn(activeTile, tileObjectsArray);
			System.out.printf("You chose tile %s%s\n", activeLetter, activeNumber);
			Gameboard.makeBoard(boardWidth, boardHeight, totalTiles, tileObjectsArray);
			Game.isGameWon(totalTiles, totalMines);
		}
		

		s.close();
		
	}

}
