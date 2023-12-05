package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MenuTest {
    @Test
    public void testMenu() {
        Menu menu = new Menu();
        assertTrue(menu instanceof Menu);
        assertEquals(menu.getClass().getName(), "es.ull.Menu");
        assertNotNull(menu);
    }
}
