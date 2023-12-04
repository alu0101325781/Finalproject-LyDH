package es.ull;

/**
 * Class that handles the game
 */
public class Game {
	public static boolean isDarkMode;

	protected Game() { } // prevents instantiation (static class

	public static final ColorScheme COLORS = new ColorScheme();
	public static final Window WINDOW = new Window("2048");
	public static final Controls CONTROLS = new Controls();
	public static final Board BOARD = new Board(4);

}