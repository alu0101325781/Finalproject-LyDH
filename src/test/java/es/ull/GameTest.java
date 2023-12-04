package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.*;

public class GameTest {
    @Test
    public void testGame() {
        Game game = new Game();
        assertTrue(game instanceof Game);
    }
}
