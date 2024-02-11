package minesweeper;

public class Gameboard {

	//take in 1 argument as a string. Depending on S, M or L, call the associated number of cells.
	public static void makeBoardTop(int gameSize) {
		
//		if (gameSize.equals("S")) {
//			System.out.println("Small game");
//		}
		System.out.print("┏━━");
		for (int i = 0; i <= gameSize-2; i++) {
		System.out.print("━┳━━");
		}
		System.out.print("━┓\n");

	}
	
	
	public static void makeBoardDivider(int gameSize) {
		
//		if (gameSize.equals("S")) {
//			System.out.println("Small game");
//		}
			System.out.print("┣━━");
			for (int i = 0; i <= gameSize-2; i++) {
			System.out.print("━╋━━");
			}
			System.out.print("━┫\n");
	}
	
	
	public static void blankRow(int gameSize) {
		for (int i = 0; i <= gameSize-1; i++) {
		System.out.print("┃   ");
		}
		System.out.print("┃\n");
	}
	
	
	public static void makeBoardBottom(int gameSize) {
		
//		if (gameSize.equals("S")) {
//			System.out.println("Small game");
//		}

		System.out.print("┗━━");
		for (int i = 0; i <= gameSize-2; i++) {
		System.out.print("━┻━━");
		}
		System.out.print("━┛\n");
	}
	

}
