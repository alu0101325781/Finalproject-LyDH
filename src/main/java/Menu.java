package main.java;

import javax.swing.*;
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        lightModeButton.addActionListener(e -> openDifficultyWindow(false));
        mainPanel.add(lightModeButton);


        darkModeButton = createStyledButton("Dark Mode", new Color(59, 57, 57),new Color(0xABFFFF) );
        darkModeButton.addActionListener(e -> openDifficultyWindow(true));
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

    private void openDifficultyWindow(boolean isDarkMode) {
        JFrame difficultyFrame = new JFrame("Select Difficulty");
        difficultyFrame.setSize(300, 250);
        difficultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        difficultyFrame.setResizable(false);
        difficultyFrame.setLocationRelativeTo(null);

        JPanel difficultyPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        difficultyPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] difficulties = {"Normal", "Difícil", "Muy Difícil", "Imposible"};

        for (String difficulty : difficulties) {
            JButton difficultyButton = createStyledButton(difficulty, Color.GRAY, Color.WHITE);
            difficultyButton.addActionListener( e -> {
                Board.setDificultad(setDifficulty(difficulty));
                difficultyFrame.dispose();
                openModeWindow(isDarkMode);
            });
            difficultyPanel.add(difficultyButton);
        }


        difficultyFrame.add(difficultyPanel);
        difficultyFrame.setVisible(true);



    }

    private int setDifficulty(String difficulty) {
        switch (difficulty) {
            case "Normal":
                return 2;
            case "Difícil":
                return 3;
            case "Muy Difícil":
                return 4;
            case "Imposible":
                return 5;
            default:
                return 2; // Default to normal difficulty
        }
    }

    private void openModeWindow(boolean isDarkMode) {
        JFrame modeFrame = new JFrame("Select Mode");
        modeFrame.setSize(300, 250);
        modeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        modeFrame.setResizable(false);
        modeFrame.setLocationRelativeTo(null);

        JPanel modePanel = new JPanel(new GridLayout(4, 1, 10, 10));
        modePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] modes = {"Normal", "Sin Fin"};

        for (String mode : modes) {
            JButton modeButton = createStyledButton(mode, Color.GRAY, Color.WHITE);
            modeButton.addActionListener( e -> {
                Board.setModo(setMode(mode));
                modeFrame.dispose();
                openGameWindow(isDarkMode);
            });
            modePanel.add(modeButton);
        }


        modeFrame.add(modePanel);
        modeFrame.setVisible(true);

    }

    private static int setMode(String modes) {
        if(modes == "Normal") {
            return 0;
        } else {
            return 1;
        }
    }


    private static void openGameWindowStatic(boolean isDarkMode) {
        Game.isDarkMode = isDarkMode;
    }

    private void openGameWindow(boolean isDarkMode) {
        openGameWindowStatic(isDarkMode);
        dispose();
    }

}