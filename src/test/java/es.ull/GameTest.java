import org.junit.jupiter.api.Test;

import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testGameInstantiation() {
        if (!GraphicsEnvironment.isHeadless()) {
            // Intenta crear una instancia de Game directamente
            try {
                Game game = new Game();
            } catch (IllegalAccessError e) {
                // Esto es lo esperado, ya que el constructor es protegido
                assertTrue(e.getMessage().contains("Cannot access"));
            }
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }
}
