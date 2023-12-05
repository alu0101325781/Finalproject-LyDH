package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ControlsTest {
 @Test
 public void testControls() {
  Controls controls = new Controls();
  assertTrue(controls instanceof Controls);
  assertEquals(controls.getClass().getName(), "es.ull.Controls");
 }


}
