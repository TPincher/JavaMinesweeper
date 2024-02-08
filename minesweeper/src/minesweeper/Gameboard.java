package minesweeper;

public class Gameboard {

	//take in 1 argument as a string. Depending on S, M or L, call the associated number of cells.
	public static void makeBoard(String gameSize) {
		
		if (gameSize.equals("S")) {
			System.out.println("Small game");
		}
		Tile.makeTile(1);
		Tile.makeTile(1);;
		System.out.print("┏━━");
		for (int i = 0; i <= 10; i++) {
		System.out.print("━┳━━");
		}
		System.out.print("━┓");
	}
	
	
	//method overload to take in 2 arguments for a custom option.
}
