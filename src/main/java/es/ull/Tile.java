package es.ull;

/**
 * Tile
 */
public class Tile {

	private int value;
	private int row;
	private int col;

	/**
	 * Constructor of the class Tile
	 */
	public Tile(int value) {
		super();
		this.value = value;
	}
	
	/**
	 * Constructor of the class Tile
	 */
	public Tile(int value, int row, int col) {
		this.value = value;
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Constructor of the class Tile
	 */
	public Tile() {
		new Tile(0);
	}

	/**
	 * Get the row of the tile
	 * @return Row of the tile
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Get the row of the tile
	 * @return Row of the tile
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Get the row of the tile
	 * @return Row of the tile
	 */
	public void setPosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Get the row of the tile
	 * @return Row of the tile
	 */
	public int merging() {
		this.value += this.value;
		return this.value;
	}
	
	/**
	 * checks whether numbered (nonzero) tile changes its position
	 * @param row
	 * @param col
	 * @return true if tile changed its position, false if not
	 */
	public boolean hasMoved(int row, int col) {
		return (!isEmpty() && ((this.row != row) || (this.col != col)));
	}
	
	/**
	 * checks whether tile is empty
	 * @return true if tile is empty, false if not
	 */
	public boolean isEmpty() {
		return (value == 0);
	}

	/**
	 * Get the row of the tile
	 * @return Row of the tile
	 */
	@Override
	public String toString() {
		return "Tile [value=" + value + "]";
	}
	
}
