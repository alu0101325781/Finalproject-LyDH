package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {

    @Test
    public void testConstructor() {
        // Configurar el modo headless
        System.setProperty("java.awt.headless", "true");

        // Resto del código de prueba
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
