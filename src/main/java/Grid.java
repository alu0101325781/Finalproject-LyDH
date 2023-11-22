package main.java;


import java.awt.Color;
// import java.awt.Component;
// import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JOptionPane;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Class Grid that handles the grid of the game
 */
public class Grid extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int TILE_RADIUS = 15;
	private static final int WIN_MARGIN = 20;
	private static final int TILE_SIZE = 65;
	private static final int TILE_MARGIN = 15;
	private static final String FONT = "Tahoma";


	private static boolean isMouseOverButton = false;

	/**
	 * Constructor of the class Grid
	 */
	public Grid() {
		super(true); // turn on doublebuffering

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getX() >= 140 && e.getX() <= 240 && e.getY() >= 30 && e.getY() <= 60) {
					endGame();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (e.getX() >= 140 && e.getX() <= 240 && e.getY() >= 30 && e.getY() <= 60) {
					isMouseOverButton = true;
					repaint();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (e.getX() >= 140 && e.getX() <= 240 && e.getY() >= 30 && e.getY() <= 60) {
					isMouseOverButton = false;
					repaint();
				}
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
					if (e.getX() >= 0 && e.getX() <= 20 && e.getY() >= 0 && e.getY() <= 20) {
							repaint();
					}
			}

			@Override
			public void mouseExited(MouseEvent e) {
					if (e.getX() >= 0 && e.getX() <= 20 && e.getY() >= 0 && e.getY() <= 20) {
							repaint();
					}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
					if (e.getX() >= 0 && e.getX() <= 20 && e.getY() >= 0 && e.getY() <= 20) {
						showLeaderboard();
					}
			}
	});		
	}

	/**
	 * Paints the grid
	 * @param g2 graphics
	 */
	@Override
	public void paintComponent(Graphics g2) {
		super.paintComponent(g2);

		Graphics2D g = ((Graphics2D) g2); // cast to get context for drawing

		/* turn on antialiasing for smooth and non-pixelated edges */
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		drawBackground(g);
		drawTitle(g);
		drawScoreBoard(g);
		drawBoard(g);
		drawButton(g);
		drawTrophy(g);
		g.dispose(); // release memory
	}

	/**
	 * Draws the button
	 * @param g graphics
	 */
	private static void drawButton(Graphics g) {
		if (isMouseOverButton) {
			g.setColor(ColorScheme.BRIGHT.darker());
		} else {
			g.setColor(ColorScheme.BRIGHT);
		}
		g.fillRoundRect(120, -50, 100, 30, TILE_RADIUS, TILE_RADIUS);
		g.setFont(new Font(FONT, Font.BOLD, 12));
		g.setColor(new Color(0XFFFFFF));
		g.drawString("End Game", 138, -31);
	}

	/**
	 * Draws the trophy
	 * @param g graphics
	 */
	private static void drawTrophy(Graphics g) {
		g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		g.setColor(new Color(000000));
		g.drawString("🏆", -16, -64);
	}

	/**
	 * Draws the title
	 * @param g graphics
	 */
	private static void drawTitle(Graphics g) {
		g.setFont( new Font(FONT, Font.BOLD, 38) );
		if (Game.isDarkMode) {
			g.setColor( ColorScheme.DARK_BRIGHT );
		} else {
			g.setColor( ColorScheme.BRIGHT );
		}
		g.drawString("2048", WIN_MARGIN, 50);
	}

	/**
	 * Draws the scoreboard
	 * @param g graphics
	 */
	private void drawScoreBoard(Graphics2D g) {
		int width = 80;
		int height = 40;
		int xOffset = Game.WINDOW.getWidth() - WIN_MARGIN - width;
		int yOffset = 20;
		g.fillRoundRect(xOffset, yOffset, width, height, TILE_RADIUS, TILE_RADIUS);
		g.setFont( new Font(FONT, Font.BOLD, 10) );
		g.setColor( new Color(0XFFFFFF) );
		g.drawString("SCORE", xOffset + 22, yOffset + 15);
		g.setFont( new Font(FONT, Font.BOLD, 12) );
		g.drawString(String.valueOf(Board.getScore()), xOffset + 35, yOffset + 30);
	}

	/**
	 * Draws the background
	 * @param g graphics
	 */
	private static void drawBackground(Graphics g) {
		if(Game.isDarkMode) {
			g.setColor(ColorScheme.DARK_WINBG);
		} else {
			g.setColor(ColorScheme.WINBG);
		}
		g.fillRect(0, 0, Game.WINDOW.getWidth(), Game.WINDOW.getHeight());
	}

	/**
	 * Draws the board
	 * @param g graphics
	 */
	private static void drawBoard(Graphics g) {
		g.translate(WIN_MARGIN, 80);
		if (Game.isDarkMode) {
			g.setColor(ColorScheme.DARK_GRIDBG);
		} else {
			g.setColor(ColorScheme.GRIDBG);
		}
		g.fillRoundRect(0, 0, Game.WINDOW.getWidth() - (WIN_MARGIN * 2), 320 + TILE_MARGIN, TILE_RADIUS, TILE_RADIUS);

		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				drawTile(g, Game.BOARD.getTileAt(row, col), col, row);
			}
		}
	}

	/**
	 * Draws the tile
	 * @param g graphics
	 * @param tile tile
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	private static void drawTile(Graphics g, Tile tile, int x, int y) {
		int value = tile.getValue();
		int xOffset = x * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
		int yOffset = y * (TILE_MARGIN + TILE_SIZE) + TILE_MARGIN;
		g.setColor(Game.COLORS.getTileBackground(value));
		g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, TILE_RADIUS, TILE_RADIUS);
		g.setColor(Game.COLORS.getTileColor(value));

		final int size = value < 100 ? 36: value < 10000 ? 26 : value < 100000 ? 20 : 18;
		final Font font = new Font(FONT, Font.BOLD, size);
		g.setFont(font);

		String s = String.valueOf(value);
		final FontMetrics fm = g.getFontMetrics(font);

		final int w = fm.stringWidth(s);
		final int h = -(int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

		if (value != 0) {
			Game.BOARD.getTileAt(y, x).setPosition(y, x); // tile gets its new position
			g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);
		}
		

		if (Game.BOARD.getWonOrLost() != null && !Game.BOARD.getWonOrLost().isEmpty()) {
			g.setColor(new Color(255, 255, 255, 40));
			g.fillRect(0, 0, Game.WINDOW.getWidth(), Game.WINDOW.getHeight());
			if (Game.isDarkMode) {
				g.setColor(ColorScheme.DARK_BRIGHT);
			} else {
				g.setColor(ColorScheme.BRIGHT);
			}
			g.setFont(new Font(FONT, Font.BOLD, 30));
			g.drawString("You " + Game.BOARD.getWonOrLost() + "!", 68, 150);
			Game.CONTROLS.unbind();
		}

	}

	/**
	 * Ends the game
	 */
	private void endGame() {
		String name = JOptionPane.showInputDialog("Enter your name: ");
		if (name == null || name.isEmpty()) {
			name = "Anonymous";
		}
		int score = Board.getScore();
		Leaderboard.addPlayer(new Player(name, score));
		System.exit(0);
	}

	/**
	 * Shows the leaderboard
	 */
	private void showLeaderboard() {
		String leaderboard = "Tabla de clasificación:\n\n";
		Leaderboard.sortPlayers();
		for (Player player : Leaderboard.loadLeaderboard()) {
			leaderboard += player.getName() + " " + player.getScore() + "\n";
		}
		JOptionPane.showMessageDialog(null, leaderboard, "Leaderboard", JOptionPane.INFORMATION_MESSAGE);
	}
}
