package minesweeper;

public class Cascade {

	public static void callCascade(Tile[] tileObjectsArray, int tileNumber, int rowLength, int totalTiles) {
		
		
		//cascade towards top
		//does the tile above exist, and is it still closed?
		if ((tileNumber - (rowLength) >= 0) && (tileObjectsArray[tileNumber - rowLength].isOpen == false)) {
			//open that tile
			tileObjectsArray[(tileNumber - rowLength)].setOpen(true);
			//add the checked tile to the opened tile array for game-end check
			Game.addToOpenArray(tileNumber);
			//check if there are no surrounding mines
			if (tileObjectsArray[tileNumber - rowLength].getSurroundingMines() == 0) {
				//cascade
				Cascade.callCascade(tileObjectsArray, (tileNumber - rowLength),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber - rowLength);
		}
		
		
		//cascade towards left
		if ((tileNumber % rowLength != 0) && (tileObjectsArray[tileNumber - 1].isOpen == false)) {
			tileObjectsArray[tileNumber - 1].setOpen(true);
			Game.addToOpenArray(tileNumber);
			if (tileObjectsArray[tileNumber - 1].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, (tileNumber - 1),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber - 1);
		}
		
		//cascade towards top-left for right-angled corner
		if ((tileNumber - (rowLength + 1) >= 0) && (tileNumber % rowLength != 0) && (tileObjectsArray[tileNumber - (rowLength + 1)].isOpen == false)) {
			tileObjectsArray[tileNumber - (rowLength + 1)].setOpen(true);
			Game.addToOpenArray(tileNumber - (rowLength + 1));
			if (tileObjectsArray[tileNumber - (rowLength + 1)].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, (tileNumber - (rowLength + 1)),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber - (rowLength + 1));
		}
		
		//cascade towards bottom
		if ((tileNumber + (rowLength + 1) <= totalTiles) && (tileObjectsArray[tileNumber + rowLength].isOpen == false)) {
			tileObjectsArray[(tileNumber + rowLength)].setOpen(true);
			Game.addToOpenArray(tileNumber);
			if (tileObjectsArray[tileNumber + rowLength].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, (tileNumber + rowLength),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber + rowLength);
		}
		
		//cascade towards bottom-left for right-angled corner
		if ((tileNumber + (rowLength - 1) < totalTiles) && (tileNumber % rowLength != 0) && (tileObjectsArray[tileNumber + (rowLength - 1)].isOpen == false)) {
			tileObjectsArray[tileNumber + (rowLength - 1)].setOpen(true);
			Game.addToOpenArray(tileNumber + (rowLength - 1));
			if (tileObjectsArray[tileNumber + (rowLength - 1)].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, (tileNumber + (rowLength - 1)),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber + (rowLength - 1));
		}
		
		//cascade towards right
		if (((tileNumber + 1) % rowLength != 0) && (tileObjectsArray[tileNumber + 1].isOpen == false)) {
			tileObjectsArray[tileNumber + 1].setOpen(true);
			Game.addToOpenArray(tileNumber);
			if (tileObjectsArray[tileNumber + 1].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, (tileNumber + 1),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber + 1);
		}
		
		//cascade towards top-right for right-angled corner
		if ((tileNumber - rowLength >= 0) && ((tileNumber + 1) % rowLength != 0) && (tileObjectsArray[( tileNumber - (rowLength - 1))].isOpen == false)) {
			tileObjectsArray[tileNumber - (rowLength - 1)].setOpen(true);
			Game.addToOpenArray(tileNumber - (rowLength - 1));
			if (tileObjectsArray[tileNumber - (rowLength - 1)].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, (tileNumber - (rowLength - 1)),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber - (rowLength - 1));
		}
		
		
		//cascade towards bottom-right for right-angled corner
		if ((tileNumber + (rowLength + 1) <= totalTiles) && ((tileNumber + 1) % rowLength != 0) && (tileObjectsArray[tileNumber + (rowLength + 1)].isOpen == false)) {
			tileObjectsArray[tileNumber + (rowLength + 1)].setOpen(true);
			Game.addToOpenArray(tileNumber + (rowLength + 1));
			if (tileObjectsArray[tileNumber + (rowLength + 1)].getSurroundingMines() == 0) {
				Cascade.callCascade(tileObjectsArray, (tileNumber + (rowLength + 1)),rowLength, totalTiles);
			}
			Game.addToOpenArray(tileNumber + (rowLength + 1));
		}
	}

}
