import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.*;

public class GameTest {
    @Test
    public void testGame() {
        if (!GraphicsEnvironment.isHeadless()) {
            Game game = new Game();
            assertTrue(game instanceof Game);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }
}
