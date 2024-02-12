package minesweeper;

import java.util.ArrayList;

public class Game {
	
	static ArrayList<Integer> mines = new ArrayList<Integer>();
	static ArrayList<Integer> checkedTiles = new ArrayList<Integer>();
	private static boolean gameActive = false;
	
	//Need a method to set the mines array at the start of game
	public static ArrayList<Integer> setMines(int mineCount, int tileCount, int startTile) {
		int mineLocation;
		for (int i = 0; i < mineCount; i++) {
			mineLocation = (int) Math.floor(Math.random() * tileCount);
			if (!mines.contains(mineLocation) && mineLocation != startTile) {
			mines.add(mineLocation);
			} 
			else i--;
		}
		return mines;
	}
	
	public static void takeTurn (int turnTile, Tile[] tileObjectsArray) {
		if (mines.contains(turnTile)) {
			System.out.println("That was a mine. You are dead.");
			setGameActive(false);
			//Would you like to play again?
		}
		if (checkedTiles.contains(turnTile)) {
			return ;
		} else {
			checkedTiles.add(turnTile);
			tileObjectsArray[turnTile].setOpen(true);
//			System.out.println(tileObjectsArray[turnTile].isOpen());
//			System.out.println(checkedTiles);
		}
	}

	public static boolean isGameActive() {
		return gameActive;
	}
	
	public static void setGameActive(boolean input) {
		gameActive = input;
	}
	
	
}