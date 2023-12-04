package es.ull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorSchemeTest {
    
    private ColorScheme colorScheme;

    @BeforeEach
    public void setUp() {
        colorScheme = new ColorScheme();
        Game.isDarkMode = false;
    }

    @Test
    public void testUpdateColors() {
        assertEquals(new Color(238, 228, 218, 90), colorScheme.getTileBackground(0));
        assertEquals(new Color(0XEEE4DA), colorScheme.getTileBackground(2));
        assertEquals(new Color(0XEDE0C8), colorScheme.getTileBackground(4));
        assertEquals(new Color(0XF2B179), colorScheme.getTileBackground(8));
        assertEquals(new Color(0XF59563), colorScheme.getTileBackground(16));
        assertEquals(new Color(0XF67C5F), colorScheme.getTileBackground(32));
        assertEquals(new Color(0XF65E3B), colorScheme.getTileBackground(64));
        assertEquals(new Color(0XEDCF72), colorScheme.getTileBackground(128));
        assertEquals(new Color(0XEDCC61), colorScheme.getTileBackground(256));
        assertEquals(new Color(0XEDC850), colorScheme.getTileBackground(512));
        assertEquals(new Color(0XEDC53F), colorScheme.getTileBackground(1024));
        colorScheme.updateColors();
    }
}
