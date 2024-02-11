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

	public void setSurroundingMines(int surroundingMines) {
		this.surroundingMines = surroundingMines;
	}

	public void TileArrayMaker (int totalTiles) {
		
	}

}
