package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
public class MenuTest {
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
        Menu menu = new Menu();

        // Test the setMode method for each game mode
        assertEquals(0, menu.setMode(Menu.NORMAL));
        assertEquals(1, menu.setMode("Sin Fin"));
    }

}
