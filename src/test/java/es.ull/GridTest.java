import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


import java.awt.*;




public class GridTest {

    @Test
    public void testGrid() {
        if (!GraphicsEnvironment.isHeadless()) {
            Grid grid = new Grid();
            assertTrue(grid instanceof Grid);
            assertEquals(grid.getClass().getName(), "Grid");
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    void testShowLeaderBoard() {
        if (!GraphicsEnvironment.isHeadless()) {
            Grid grid = new Grid();
            assertDoesNotThrow(() -> grid.showLeaderboard());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }




}
