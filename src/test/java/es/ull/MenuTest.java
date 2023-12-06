package es.ull;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void testMenu() {
        if (!GraphicsEnvironment.isHeadless()) {
            Menu menu = new Menu();
            assertTrue(menu instanceof Menu);
            assertEquals(menu.getClass().getName(), "es.ull.Menu");
            assertNotNull(menu);
            assertFalse(menu.isResizable());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }
    @Test
    public void testStrings() {
        assertEquals(Menu.NORMAL, "Normal");
        assertEquals(Menu.DIFICIL, "Difícil");
        assertEquals(Menu.MUYDIFICIL, "Muy Difícil");
        assertEquals(Menu.IMPOSIBLE, "Imposible");
    }

    @Test
    public void testCreateStyledButton() {
        if (!GraphicsEnvironment.isHeadless()) {
            // Arrange
            Color backgroundColor = Color.RED;
            Color foregroundColor = Color.BLACK;
            String buttonText = "Click me";

            // Create an instance of Menu
            Menu menu = new Menu();

            // Act
            RoundButton button = menu.createStyledButton(buttonText, backgroundColor, foregroundColor);
            // Assert initial state
            assertEquals(buttonText, button.getText());
            assertEquals(backgroundColor, button.backgroundColor);
            assertEquals(foregroundColor, button.getForeground());
            assertEquals(new Font("Tahoma", Font.BOLD, 20), button.getFont());

            // Resto del código de la prueba...
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void testOpenDifficultyWindow() {
        if (!GraphicsEnvironment.isHeadless()) {
            // Arrange
            boolean darkMode = true;

            // Create an instance of Menu
            Menu menu = new Menu();

            // Act
            menu.openDifficultyWindow(!darkMode);
            // Assert initial state
            assertEquals(!darkMode, es.ull.Game.isDarkMode);
            assertEquals(300, menu.getWidth());
            assertEquals(250, menu.getHeight());
            assertEquals(1, menu.getContentPane().getComponentCount());

            // Resto del código de la prueba...
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }





}
