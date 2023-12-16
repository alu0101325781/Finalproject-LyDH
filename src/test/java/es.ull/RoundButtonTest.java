import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RoundButtonTest {
  
  @Test
  public void testConstructor() {
    // Arrange
    String text = "Test";
    Color backgroundColor = Color.BLACK;
    Color foregroundColor = Color.WHITE;

    // Act
    RoundButton button = new RoundButton(text, backgroundColor, foregroundColor);

    // Assert
    assertNotNull(button);
    assertEquals(text, button.getText());
    assertEquals(backgroundColor, button.backgroundColor);
    assertEquals(foregroundColor, button.getForeground());
    assertEquals(new Font("Tahoma", Font.BOLD, 20), button.getFont());
  }

  @Test
  public void testPaintComponent() {
    // Arrange
    String text = "Test";
    Color backgroundColor = Color.BLACK;
    Color foregroundColor = Color.WHITE;
    RoundButton button = new RoundButton(text, backgroundColor, foregroundColor);

    // Act
    // Create a BufferedImage to simulate the graphics environment
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = image.createGraphics();

    // Call paintComponent with the simulated graphics environment
    button.paintComponent(g2);

    // Assert
    assertNotNull(button);
    assertEquals(backgroundColor, button.backgroundColor);
  }

}
