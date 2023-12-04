
package es.ull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WindowTest {

    @Test
    public void testConstructor() {
        // Arrange
        String title = "Test";
        int width = 100;
        int height = 200;

        // Act
        Window window = new Window(title);
        window.setSize(width, height);


    }
}
