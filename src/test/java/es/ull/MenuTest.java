package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
public class MenuTest {
    @Test
    public void testSetDifficulty() {
        // Test the setDifficulty method for each difficulty level
        assertEquals(2, Menu.setDifficulty(Menu.NORMAL));
        assertEquals(3, Menu.setDifficulty(Menu.DIFICIL));
        assertEquals(4, Menu.setDifficulty(Menu.MUYDIFICIL));
        assertEquals(5, Menu.setDifficulty(Menu.IMPOSIBLE));
    }

    @Test
    public void testSetMode() {
        // Test the setMode method for each game mode
        assertEquals(0, Menu.setMode(Menu.NORMAL));
        assertEquals(1, Menu.setMode("Sin Fin"));
    }

}
