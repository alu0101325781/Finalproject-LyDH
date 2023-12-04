package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;


public class WindowTest {

    @Test
    public void testConstructor() {
        // Arrange
        String title = "Test";

        // Act
        Window window = new Window(title);

        // Assert
        assertNotNull(window);
        assertEquals(title, window.getTitle());
        assertFalse(window.isResizable());
        assertTrue(window.isFocusable());
        assertTrue(window.isVisible());
    }
}