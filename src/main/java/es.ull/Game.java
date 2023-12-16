/**
 * Class that handles the game
 */
public class Game {
	public static boolean isDarkMode;

	protected Game() { } // prevents instantiation (static class

	public static ColorScheme COLORS = new ColorScheme();
	public static Window WINDOW = new Window("2048");
	public static Controls CONTROLS = new Controls();
	public static final Board BOARD = new Board(4);

}
