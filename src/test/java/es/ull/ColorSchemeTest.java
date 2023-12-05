package es.ull;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
    @Test
    public void testColors() {
        if (!GraphicsEnvironment.isHeadless()) {
            ColorScheme colorScheme = new ColorScheme();
            assertTrue(es.ull.ColorScheme.WINBG instanceof Color);
            assertTrue(es.ull.ColorScheme.GRIDBG instanceof Color);
            assertTrue(es.ull.ColorScheme.BRIGHT instanceof Color);
            assertTrue(es.ull.ColorScheme.LIGHT instanceof Color);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }
}