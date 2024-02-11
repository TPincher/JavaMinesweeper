package minesweeper;

import java.util.ArrayList;

public class Game {
	
	static ArrayList<Integer> mines = new ArrayList<Integer>();
	static ArrayList<Integer> checkedTiles = new ArrayList<Integer>();
	
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
	
	
	public static void takeTurn (int turnTile) {
		if (mines.contains(turnTile)) {
			System.out.println("That was a mine. You are dead.");
		}
	}

	
	
}