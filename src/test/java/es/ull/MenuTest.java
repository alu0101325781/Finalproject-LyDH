package es.ull;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
public class MenuTest {
    @Test
    public void testMenu() {
        if (!GraphicsEnvironment.isHeadless()) {
            Menu menu = new Menu();
            assertTrue(menu instanceof Menu);
            assertEquals(menu.getClass().getName(), "es.ull.Menu");
            assertNotNull(menu);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

}
