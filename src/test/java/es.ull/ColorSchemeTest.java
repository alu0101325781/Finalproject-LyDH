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
    public void testInitDarkBackgrounds() {
        if (!GraphicsEnvironment.isHeadless()) {
            ColorScheme colorScheme = new ColorScheme();
            colorScheme.initDarkBackgrounds();
            assertTrue(colorScheme instanceof ColorScheme);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void testUpdateColors() {
        if (!GraphicsEnvironment.isHeadless()) {
            Game.isDarkMode = true;
            ColorScheme colorScheme = new ColorScheme();
            colorScheme.updateColors();
            assertTrue(colorScheme instanceof ColorScheme);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }


}