package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.*;
public class GridTest {
    @Test
    public void testGrid() {
        if (!GraphicsEnvironment.isHeadless()) {
            Grid grid = new Grid();
            assertTrue(grid instanceof Grid);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }
}
