package minesweeper;

public class Tile {
	
	
	private int tileNumber;
	private boolean hasMine;
	private boolean isOpen;
	private boolean hasFlag;
	private int surroundingMines;
	
	
	public Tile (int tileNumber, boolean hasMine, boolean isOpen, boolean hasFlag, int surroundingMines) {
	
		this.tileNumber = tileNumber;
		this.hasMine = hasMine;
		this.isOpen = isOpen;
		this.hasFlag = hasFlag;
		this.surroundingMines = surroundingMines;

	}
	
	
	public int getTileNumber() {
		return tileNumber;
	}

	public void setTileNumber(int tileNumber) {
		this.tileNumber = tileNumber;
	}

	public boolean isHasMine() {
		return hasMine;
	}

	public void setHasMine(boolean hasMine) {
		this.hasMine = hasMine;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isHasFlag() {
		return hasFlag;
	}

	public void setHasFlag(boolean hasFlag) {
		this.hasFlag = hasFlag;
	}

	public int getSurroundingMines() {
		return surroundingMines;
	}

	public void setSurroundingMines(Tile[] tileObjectsArray, int tileNumber, int rowLength, int totalTiles) {

		int mineCount = 0;
		
		
		//top-left
		if ((tileNumber - (rowLength + 1) >= 0) && (tileNumber % rowLength != 0) && (tileObjectsArray[tileNumber - (rowLength + 1)].hasMine == true)) {
				mineCount += 1;
			};
		
		//top
		if ((tileNumber - (rowLength + 1) >= 0) && (tileObjectsArray[tileNumber - rowLength].hasMine == true)) {
				mineCount += 1;
			};
		
		//top-right
		if ((tileNumber - (rowLength + 1) >= 0) && ((tileNumber + 1) % rowLength != 0) && (tileObjectsArray[( tileNumber - (rowLength - 1))].hasMine == true)) {
				mineCount += 1;
			};
		
		//left
		if ((tileNumber % rowLength != 0) && (tileObjectsArray[tileNumber - 1].hasMine == true)) {
				mineCount += 1;
			};
		
		//right
		if (((tileNumber + 1) % rowLength != 0) && (tileObjectsArray[tileNumber + 1].hasMine == true)) {
					mineCount += 1;
		};
		
		//bottom-left
		if ((tileNumber + (rowLength + 1) <= totalTiles) && (tileNumber % rowLength != 0) && (tileObjectsArray[tileNumber + (rowLength - 1)].hasMine == true)) {
				mineCount += 1;
		};
		
		//bottom
		if ((tileNumber + (rowLength + 1) <= totalTiles) && (tileObjectsArray[tileNumber + rowLength].hasMine == true)) {
				mineCount += 1;
		};
		
		//bottom-right
		if ((tileNumber + (rowLength + 1) <= totalTiles) && ((tileNumber + 1) % rowLength != 0) && (tileObjectsArray[tileNumber + (rowLength + 1)].hasMine == true)) {
				mineCount += 1;
		};
		
		// This will display a tile as a '9' if it has a mine on it, which a non-mined tile can never be.
		if (tileObjectsArray[tileNumber].hasMine == true) {
			mineCount = 9;
		}

		
		this.surroundingMines = mineCount;
	}

	public void TileArrayMaker (int totalTiles) {
		
	}

}
