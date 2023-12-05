package es.ull;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testMain() {
        Main main = new Main();
        assertTrue(main instanceof Main);
        assertEquals(main.getClass().getName(), "es.ull.Main");
    }
}
