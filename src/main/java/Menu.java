package main.java;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

    public Menu() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        JButton lightModeButton;
        JButton darkModeButton;


        // Crear un panel principal con un diseño de cuadrícula
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Crear botones con un diseño más limpio y agregarlos al panel principal
        lightModeButton = createStyledButton("Light Mode", new Color(214, 204, 194, 255), new Color(0xFFE76F51, true));
        lightModeButton.addActionListener(e -> openGameWindow(false));
        mainPanel.add(lightModeButton);

        darkModeButton = createStyledButton("Dark Mode", new Color(59, 57, 57),new Color(0xABFFFF) );
        darkModeButton.addActionListener(e -> openGameWindow(true));
        mainPanel.add(darkModeButton);

        // Agregar el panel principal al JFrame
        add(mainPanel);

        // Hacer visible la ventana
        setVisible(true);
    }

    private RoundButton createStyledButton(String text, Color backgroundColor, Color foregroundColor) {
        RoundButton button = new RoundButton(text, backgroundColor, foregroundColor);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(backgroundColor.brighter());
                repaint();
                button.setSize(new Dimension(button.getWidth() + 10, button.getHeight() + 5));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setSize(new Dimension(button.getWidth() - 10, button.getHeight() - 5));
            }

        });
        return button;
    }


    private void openGameWindow(boolean isDarkMode) {
        Game game = new Game(isDarkMode);
        dispose(); // Cierra la ventana actual
    }

}
