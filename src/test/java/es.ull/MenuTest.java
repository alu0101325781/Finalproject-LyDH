import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void testMenu() {
        if (!GraphicsEnvironment.isHeadless()) {
            Menu menu = new Menu();
            assertTrue(menu instanceof Menu);
            assertEquals(menu.getClass().getName(), "Menu");
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
            assertEquals(darkMode, Game.isDarkMode);
            assertEquals(300, menu.getWidth());
            assertEquals(250, menu.getHeight());
            assertEquals(1, menu.getContentPane().getComponentCount());

            // Resto del código de la prueba...
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void testSetDifficulty_Normal() {
        if (!GraphicsEnvironment.isHeadless()) {
            // Arrange
            Menu menu = new Menu();

            // Act
            int result = menu.setDifficulty(Menu.NORMAL);

            // Assert
            assertEquals(2, result);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void testSetDifficulty_Dificil() {
        if (!GraphicsEnvironment.isHeadless()) {
            // Arrange
            Menu menu = new Menu();

            // Act
            int result = menu.setDifficulty(Menu.DIFICIL);

            // Assert
            assertEquals(3, result);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void testOpenModeWindow() {
        if (!GraphicsEnvironment.isHeadless()) {
            // Arrange
            boolean darkMode = true;
            Menu menu = new Menu();

            // Act
            menu.openModeWindow(!darkMode);

            // Assert
            assertNotNull(menu.getModeFrame());
            assertFalse(menu.getModeFrame().isResizable());
            assertEquals(300, menu.getModeFrame().getWidth());
            assertEquals(250, menu.getModeFrame().getHeight());
            assertEquals(WindowConstants.EXIT_ON_CLOSE, menu.getModeFrame().getDefaultCloseOperation());

            // Resto del código de la prueba...
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

}
