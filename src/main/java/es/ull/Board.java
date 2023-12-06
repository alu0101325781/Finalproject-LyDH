package es.ull;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;


/**
 * Board
 * @author petrnemecek
 *
 */
public class Board {

	private int size; 						// size of the grid
	private static int score; 						// game score
	private int emptyTiles;					// number of tiles with zero value
	boolean gameover = false; 		// game is over when 2048 tile is found
	String wonOrLost;				// won or lost
	boolean genNewTile = false;		// generate new tile when any tile moved
	private List<List<Tile>> tiles;			// board

	private static int dificultad ;  // Nueva variable para almacenar la dificultad
	private static int modo;		// Nueva variable para almacenar el modo



	//Gestión de dificultad, generador de tiles (Tocado también en el newRandomTile())
	//En el genInitTiles() modificado para que cree tiles = numberTiles al empezar



	/**
	 * Constructor
	 * @param size of the grid
	 */
	public Board(int size) {
		super();
		this.size = size;
		this.emptyTiles = this.size * this.size;
		this.tiles = new ArrayList<>();



		start();
	}

	/**	
	 * Setters
	 */
	public static void setDificultad(int dificultad) {
		Board.dificultad = dificultad;
	}
	public static void setModo(int modo) {
		Board.modo = modo;
	}

	/**
	 * Initialize board with empty tiles
	 */
	void initialize() {
		for (int row = 0; row < this.size; row++) {
			tiles.add(new ArrayList<>());
			for (int col = 0; col < this.size; col++) {
				tiles.get(row).add(new Tile());
			}
		}
	}

	/**
	 * Start the game
	 */
	private void start() {
		Game.CONTROLS.bind();
		initialize();
		genInitTiles();
	}

	/**
	 * Returns size of the grid
	 * @return size of the grid
	 */
	public int getSize() {
		return size;
	}

	public int getDificultad() {
		return dificultad;
	}

	public int getModo() {
		return modo;
	}

	/**
	 * Set size of the grid
	 * @param size of the grid
	 */
	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * Returns a list of lists of {@link Tile}
	 * @return a list of lists of {@link Tile}
	 */
	public List<List<Tile>> getTiles() {
		return tiles;
	}

	/**
	 * Set a list of lists of {@link Tile}
	 * @param tiles a list of lists of {@link Tile}
	 */
	public void setTiles(List<List<Tile>> tiles) {
		this.tiles = tiles;
	}

	/**
	 * Returns a {@link Tile} at given position
	 * @param row
	 * @param col
	 * @return {@link Tile} at given position
	 */
	public Tile getTileAt(int row, int col) {
		return tiles.get(row).get(col);
	}

	/**
	 * Set a {@link Tile} at given position
	 * @param row
	 * @param col
	 * @param t {@link Tile} to be set
	 */
	public void setTileAt(int row, int col, Tile t) {
		tiles.get(row).set(col, t);
	}

	/**
	 * Remove a {@link Tile} at given position
	 * @param row
	 * @param col
	 */
	public void remTileAt(int row, int col) {
		tiles.get(row).remove(col);
	}

	/**
	 * Returns game score
	 * @return game score
	 */
	public static int getScore() {
		return score;
	}

	/**
	 * merges two touching {@link Tile} with the same number into one
	 * @param sequence of {@link Tile}
	 * @return merged sequence of {@link Tile}
	 */
	List<Tile> mergeTiles(List<Tile> sequence) {
		    for (int l = 0; l < sequence.size() - 1; l++) {
		        if (sequence.get(l).getValue() == sequence.get(l + 1).getValue()) {
		            int value = sequence.get(l).merging();
		            if (value == 2048) {
		                gameover = true;
		            }
		            score += value;
		            sequence.remove(l + 1);
		            genNewTile = true; // board has changed its state
		            emptyTiles++;
		        }
		    }
		    return sequence;
	}

	/**
	 * merges two touching {@link Tile} with the same number into one
	 * @param sequence of {@link Tile}
	 * @return merged sequence of {@link Tile}
	 */
	List<Tile> mergeTilesMode1(List<Tile> sequence) {
		    for (int l = 0; l < sequence.size() - 1; l++) {
		        if (sequence.get(l).getValue() == sequence.get(l + 1).getValue()) {
		            int value = sequence.get(l).merging();
		            score += value;
		            if (value == 4096) {
		                System.out.printf("El número es: %d%n", value);
		            }
		            sequence.remove(l + 1);
		            genNewTile = true; // board has changed its state
		            emptyTiles++;
		        }
		    }
		    return sequence;
	}


	/**
	 * creates empty {@link Tile} instances and adds them to the left (resp. top) of merged sequence to fit the board
	 * @param merged sequence of {@link Tile}
	 * @return refilled sequence with required number of empty {@link Tile}
	 */
	List<Tile> addEmptyTilesFirst(List<Tile> merged) {
		for (int k = merged.size(); k < size; k++) {
			merged.add(0, new Tile());
		}
		return merged;
	}

	/**
	 * creates empty {@link Tile} instances and adds them to the right (resp. bottom) of merged sequence to fit the board
	 * @param merged sequence of {@link Tile}
	 * @return refilled sequence with required number of empty {@link Tile}
	 */
	List<Tile> addEmptyTilesLast(List<Tile> merged) { // boolean last/first
		for (int k = merged.size(); k < size; k++) {
			merged.add(k, new Tile());
		}
		return merged;
	}

	/**
	 * removes empty {@link Tile} from the sequence
	 * @param row
	 * @return sequence of non-empty {@link Tile}
	 */
	List<Tile> removeEmptyTilesRows(int row) {

		List<Tile> moved = new ArrayList<>();

		for (int col = 0; col < size; col++) {
			if (!getTileAt(row, col).isEmpty()) { // NOT empty
				moved.add(getTileAt(row, col));
			}
		}

		return moved;
	}

	/**
	 * removes empty {@link Tile} from the sequence
	 * @param row
	 * @return sequence of non-empty {@link Tile}
	 */
	List<Tile> removeEmptyTilesCols(int row) {

		List<Tile> moved = new ArrayList<>();

		for (int col = 0; col < size; col++) {
			if (!getTileAt(col, row).isEmpty()) { // NOT empty
				moved.add(getTileAt(col, row));
			}
		}

		return moved;
	}

	/**
	 * sets the sequence of {@link Tile} to the board
	 * @param moved sequence of {@link Tile}
	 * @param row
	 * @return sequence of {@link Tile}
	 */
	List<Tile> setRowToBoard(List<Tile> moved, int row) {
		for (int col = 0; col < tiles.size(); col++) {
			if (moved.get(col).hasMoved(row, col)) {
				genNewTile = true;
			}
			setTileAt(row, col, moved.get(col));
		}

		return moved;
	}

	/**
	 * sets the sequence of {@link Tile} to the board
	 * @param moved sequence of {@link Tile}
	 * @param row
	 * @return sequence of {@link Tile}
	 */
	List<Tile> setColToBoard(List<Tile> moved, int row) {
		for (int col = 0; col < tiles.size(); col++) {
			if (moved.get(col).hasMoved(col, row)) {
				genNewTile = true;
			}
			setTileAt(col, row, moved.get(col));
		}

		return moved;
	}

	/**	
	 * Moves tiles up
	 */
	public void moveUp() {

		List<Tile> moved;

		for (int row = 0; row < size; row++) {

			moved = removeEmptyTilesCols(row);
			if(modo == 0) {
				moved = mergeTiles(moved);
			} else {
				moved = mergeTilesMode1(moved);
			}
			moved = addEmptyTilesLast(moved);
			moved = setColToBoard(moved, row);

		}

	}

	/**
	 * Moves tiles down
	 */
	public void moveDown() {

		List<Tile> moved;

		for (int row = 0; row < size; row++) {

			moved = removeEmptyTilesCols(row);
			if(modo == 0) {
				moved = mergeTiles(moved);
			} else {
				moved = mergeTilesMode1(moved);
			}
			moved = addEmptyTilesFirst(moved);
			moved = setColToBoard(moved, row);

		}

	}

	/**
	 * Moves tiles left
	 */
	public void moveLeft() {

		List<Tile> moved;

		for (int row = 0; row < size; row++) {

			moved = removeEmptyTilesRows(row);
			if(modo == 0) {
				moved = mergeTiles(moved);
			} else {
				moved = mergeTilesMode1(moved);
			}
			moved = addEmptyTilesLast(moved);
			moved = setRowToBoard(moved, row);

		}

	}

	/**
	 * Moves tiles right
	 */
	public void moveRight() {

		List<Tile> moved;

		for (int row = 0; row < size; row++) {

			moved = removeEmptyTilesRows(row);
			if(modo == 0) {
				moved = mergeTiles(moved);
			} else {
				moved = mergeTilesMode1(moved);
			}
			moved = addEmptyTilesFirst(moved);
			moved = setRowToBoard(moved, row);

		}

	}

	/**
	 * Checks if the game is over
	 */
	public void isGameOver() {
		if (gameover) {
			setWonOrLost("WON");
		} else {
			if (isFull()) {
				if (!isMovePossible()) {
					// you lost (board is full with no tiles to merge)
					setWonOrLost("LOST");
				}

			} else {
				newRandomTile(); // game continues
			}
		}
	}

	boolean getGameOver() {
		return gameover;
	}

	/**
	 * Checks if the board is full
	 * @return true if the board is full
	 */
	 boolean isFull() {
		return emptyTiles == 0;
	}

	/**
	 * Checks if there is a possible move
	 * @return true if there is a possible move
	 */
	 boolean isMovePossible() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size - 1; col++) {
				if (getTileAt(row, col).getValue() == getTileAt(row, col + 1).getValue()) {
					return true;
				}
			}
		}

		for (int row = 0; row < size - 1; row++) {
			for (int col = 0; col < size; col++) {
				if (getTileAt(col, row).getValue() == getTileAt(col, row + 1).getValue()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Generates new tiles
	 */
	private void genInitTiles() {
		genNewTile = true;
		newRandomTile();
		if (Board.dificultad == 2){
			Board.dificultad = Board.dificultad/2;
		}
	}

	/**
	 * Generates new tiles
	 */
	private void newRandomTile() {

		if (genNewTile) {
			SecureRandom secureRandom = new SecureRandom();

			int tilesToGenerate = Math.min(Board.dificultad, emptyTiles);

			for (int i = 0; i < tilesToGenerate; i++) {
				int row;
				int col;
				double randomValue = secureRandom.nextDouble();
				int value = randomValue < 0.9 ? 2 : 4;

				do {
					row = secureRandom.nextInt(size);
					col = secureRandom.nextInt(size);
				} while (getTileAt(row, col).getValue() != 0);

				setTileAt(row, col, new Tile(value, row, col));
				emptyTiles--;
			}

			genNewTile = false;
		}
	}

	/**
	 * Shows the board
	 */
	protected void show() {
		for (int i = 0; i < 2; ++i) System.out.println();
		System.out.println("SCORE: " + score);
		for (int i = 0; i < tiles.size(); i++) {
			for (int j = 0; j < tiles.get(i).size(); j++) {
				System.out.format("%-5d", getTileAt(i, j).getValue());
			}
			System.out.println();
		}
	}

	/**
	 * Returns game status
	 * @return game status
	 */
	public String getWonOrLost() {
		return wonOrLost;
	}

	/**
	 * Set game status
	 * @param wonOrLost game status
	 */
	public void setWonOrLost(String wonOrLost) {
		this.wonOrLost = wonOrLost;
	}

}
