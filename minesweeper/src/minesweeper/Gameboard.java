package minesweeper;

public class Gameboard {

	
	public static void makeBlankBoard(int boardWidth, int boardHeight, int totalTiles) {
		makeBoardLetters(boardWidth);
		makeBoardTop(boardWidth);
		blankPlayingRow(boardWidth);
		for (int x = 0; x <= boardHeight - 2; x++) {
		makeBoardDivider(boardWidth);
		blankPlayingRow(boardWidth, x);
		}
		makeBoardBottom(boardWidth);
	}
	
	
	public static void makeBoard(int boardWidth, int boardHeight, int totalTiles, Tile[] tileObjectsArray) {
		makeBoardLetters(boardWidth);
		makeBoardTop(boardWidth);
		playingRow(boardWidth, tileObjectsArray);
		for (int x = 0; x <= boardHeight - 2; x++) {
		makeBoardDivider(boardWidth);
		playingRow(boardWidth, totalTiles, tileObjectsArray, x);
		}
		makeBoardBottom(boardWidth);
	}
	
		
	private static void makeBoardLetters(int boardWidth) {
		char letter = 'A';
		System.out.print("   ");
		for (int i = 0; i <= boardWidth - 2; i++) {
		    System.out.print("  " + (char) (letter + i) + " ");
		}
		System.out.print("  " + (char) (letter + (boardWidth - 1)) + "\n");
	}
	

	private static void makeBoardTop(int gameSize) {
		System.out.print("   ┏━━");
		for (int i = 0; i <= gameSize-2; i++) {
		System.out.print("━┳━━");
		}
		System.out.print("━┓\n");

	}
	
	
	private static void makeBoardDivider(int gameSize) {
			System.out.print("   ┣━━");
			for (int i = 0; i <= gameSize-2; i++) {
			System.out.print("━╋━━");
			}
			System.out.print("━┫\n");
	}
	
	
	private static void blankPlayingRow(int boardWidth) {
		System.out.print("1  ");
		for (int i = 0; i <= boardWidth - 1; i++) {
			System.out.print("┃   ");
		}
		System.out.print("┃\n");
	}
	
	
	private static void playingRow(int boardWidth, Tile[] tileObjectsArray) {
		System.out.print("1  ");
		for (int i = 0; i <= boardWidth - 1; i++) {
			if (tileObjectsArray[i].isOpen()) {
				System.out.printf("┃ %s ", tileObjectsArray[i].getSurroundingMines());
			} else {
			System.out.print("┃   ");
			}
		}
		System.out.print("┃\n");
	}
	
	
	private static void blankPlayingRow(int gameSize, int row) {
		if ((row + 2) < 10) {
			System.out.print((row + 2) + "  ");
			} else {
				System.out.print((row + 2) + " ");
			}
		for (int i = 0; i <= gameSize-1; i++) {
			System.out.print("┃   ");
		}
		System.out.print("┃\n");
	}
	
	
	private static void playingRow(int gameSize, int totalTiles, Tile[] tileObjectsArray, int row) {
		if ((row + 2) < 10) {
			System.out.print((row + 2) + "  ");
			} else {
				System.out.print((row + 2) + " ");
			}
		for (int i = 0; i <= gameSize-1; i++) {
			if (tileObjectsArray[i + ((row + 1) * gameSize)].isOpen()) {
			System.out.printf("┃ %s ", tileObjectsArray[i + ((row+ 1) * gameSize)].getSurroundingMines());
			} else {
				System.out.printf("┃   ");
			}
		}
		System.out.print("┃\n");
	}
	
	
	private static void makeBoardBottom(int gameSize) {

		System.out.print("   ┗━━");
		for (int i = 0; i <= gameSize-2; i++) {
		System.out.print("━┻━━");
		}
		System.out.print("━┛\n");
	}
	

}
