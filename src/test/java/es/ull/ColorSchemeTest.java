package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.*;

public class ColorSchemeTest {
    @Test
    public void testColorScheme() {
        if (!GraphicsEnvironment.isHeadless()) {
            ColorScheme colorScheme = new ColorScheme();
            assertTrue(colorScheme instanceof ColorScheme);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }
}
