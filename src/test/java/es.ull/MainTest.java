import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testMain() {
        Main main = new Main();
        assertTrue(main instanceof Main);
        assertEquals(main.getClass().getName(), "Main");
        assertNotNull(main);
    }
    @Test
    public void testMenuCreation() {
        if(!GraphicsEnvironment.isHeadless()) {
            Menu menu = new Menu();
            assertTrue(menu instanceof Menu);
            assertEquals(menu.getClass().getName(), "Menu");
            assertNotNull(menu);
            assertTrue(menu.isVisible());
        } else {
            System.out.println("Headless environment detected, skipping test");
        }
    }

    @Test
    public void testSetMode(){
        if(!GraphicsEnvironment.isHeadless()) {
            Menu menu = new Menu();
            assertEquals(Menu.setMode("Normal"), 0);
            assertEquals(Menu.setMode("Sín Fin"), 1);
        } else {
            System.out.println("Headless environment detected, skipping test");
        }

    }
}
