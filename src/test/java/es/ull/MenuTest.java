package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
public class MenuTest {
    @Test
    public void testSetDifficulty() {
        Menu menu = new Menu();

        // Test the setDifficulty method for each difficulty level
        assertEquals(2, menu.setDifficulty(Menu.NORMAL));
        assertEquals(3, menu.setDifficulty(Menu.DIFICIL));
        assertEquals(4, menu.setDifficulty(Menu.MUYDIFICIL));
        assertEquals(5, menu.setDifficulty(Menu.IMPOSIBLE));
    }

    @Test
    public void testSetMode() {
        // Test the setMode method for each game mode
        assertEquals(0, Menu.setMode(Menu.NORMAL));
        assertEquals(1, Menu.setMode("Sin Fin"));
    }

}
