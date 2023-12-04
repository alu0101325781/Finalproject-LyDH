package es.ull;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Class that handles the round buttons
 */
public class RoundButton extends JButton {
    Color backgroundColor;

    /**
     * Constructor of the class RoundButton
     * @param text Text of the button
     * @param backgroundColor Background color of the button
     * @param foregroundColor Foreground color of the button
     */
    public RoundButton(String text, Color backgroundColor, Color foregroundColor) {
        super(text);
        this.backgroundColor = backgroundColor;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(foregroundColor);
        setFont(new Font("Tahoma", Font.BOLD, 20));
    }

    /**
     * Paints the button
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 15, 15);

        super.paintComponent(g);
    }

    /**
     * Paints the border of the button
     */
    @Override
    protected void paintBorder(Graphics g) {
        int borderWidth = 2; // Adjust the thickness as needed
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backgroundColor);

        for (int i = 0; i < borderWidth; i++) {
            g2.drawRoundRect(i, i, getSize().width - i * 2 - 1, getSize().height - i * 2 - 1, 15, 15);
        }
    }

}
