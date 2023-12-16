import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Class that handles the keyboard input
 */
public class Controls implements KeyListener {

	/**
	 * Empty constructor
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// Empty because KeyListener requires it as an Interface
	}
	public void keyReleased(KeyEvent e) {
		// Empty because KeyListener requires it as an Interface
	}
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();

		switch (keyCode) {
			case KeyEvent.VK_UP:
				Game.BOARD.moveUp();
				break;
			case KeyEvent.VK_DOWN:
				Game.BOARD.moveDown();
				break;
			case KeyEvent.VK_LEFT:
				Game.BOARD.moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				Game.BOARD.moveRight();
				break;
			case KeyEvent.VK_ESCAPE:
				Game.WINDOW.dispose();
				break;
			default:
				break;
		}
		
		Game.BOARD.isGameOver();
		Game.WINDOW.repaint();
		
	}

	/**
	 * Binds the keyboard input to the game
	 */
	public void bind() {
		Game.WINDOW.addKeyListener(this);
	}

	/**
	 * Unbinds the keyboard input from the game
	 */
	public void unbind() {
		Game.WINDOW.removeKeyListener(this);
	}

}
