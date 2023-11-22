package main.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.WindowConstants;

/**
 * Window
 * @author petrnemecek
 *
 */

public class Window extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8804446439773037674L;
	private int xWidth = 375;
	private int yHeight = 450;

	/**
	 * Constructor of the class Window
	 * @param title Title of the window
	 */
	public Window(String title) {
		super(title); // Window title

		this.setLayout( new BorderLayout());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // close window to exit
		this.setSize(this.xWidth, this.yHeight);
		this.setLocationRelativeTo(null); // centering

		this.setResizable(false);
		this.setFocusable(true); // set focus on window so KeyListener works	

		getContentPane().add( new Grid() );
		
        JPanel panel = new JPanel();
		panel.add(createSimpleButton("NEW GAME"));
		
        panel.setPreferredSize(new Dimension(1000, 760));


		this.setVisible(true); // show window

	}

	/**
	 * Creates a simple button
	 * @param text Text of the button
	 * @return Button
	 */
	private static JButton createSimpleButton(String text) {
		JButton button = new JButton(text);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		button.setBorder(compound);
		return button;
	}

	/**
	 * Get the width of the window
	 * @return Width of the window
	 */
	@Override
	public int getWidth() {
		return xWidth;
	}

	/**
	 * Get the height of the window
	 * @return Height of the window
	 */
	@Override
	public int getHeight() {
		return yHeight;
	}

}