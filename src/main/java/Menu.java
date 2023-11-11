package main.java;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JButton startButton;
    private JButton darkModeButton;

    public Menu() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setResizable(false);
        setLocationRelativeTo(null);


        // Crear un panel principal con un diseño de cuadrícula
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Crear botones con un diseño más limpio y agregarlos al panel principal
        startButton = createStyledButton("Light Mode");
        startButton.addActionListener(e -> openGameWindow(false));
        mainPanel.add(startButton);

        darkModeButton = createStyledButton("Dark Mode");
        darkModeButton.addActionListener(e -> openGameWindow(true));
        mainPanel.add(darkModeButton);

        // Agregar el panel principal al JFrame
        add(mainPanel);

        // Hacer visible la ventana
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setBackground(new Color(117, 111, 108));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    private void openGameWindow(boolean isDarkMode) {
        Game game = new Game(isDarkMode);
        dispose(); // Cierra la ventana actual
    }

}
