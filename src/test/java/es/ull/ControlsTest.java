package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.*;
 import java.awt.event.KeyEvent;

import java.awt.event.KeyEvent;

public class ControlsTest {

    @Test
    public void testKeyPressedUp() {
        Controls controls = new Controls();
        KeyEvent keyEvent = new KeyEvent(new Component() {}, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, 'W');
        controls.keyPressed(keyEvent);
        // Aquí puedes agregar aserciones para verificar el comportamiento esperado después de presionar la tecla UP
        // Por ejemplo, podrías verificar si la función moveUp() se llamó en el objeto Game.BOARD.
    }

    @Test
    public void testKeyPressedDown() {
        Controls controls = new Controls();
        KeyEvent keyEvent = new KeyEvent(new Component() {}, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'S');
        controls.keyPressed(keyEvent);
        // Añade aserciones para verificar el comportamiento esperado después de presionar la tecla DOWN
    }

    @Test
    public void testKeyPressedLeft() {
        Controls controls = new Controls();
        KeyEvent keyEvent = new KeyEvent(new Component() {}, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, 'A');
        controls.keyPressed(keyEvent);
        // Añade aserciones para verificar el comportamiento esperado después de presionar la tecla LEFT
    }

    @Test
    public void testKeyPressedRight() {
        Controls controls = new Controls();
        KeyEvent keyEvent = new KeyEvent(new Component() {}, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, 'D');
        controls.keyPressed(keyEvent);
        // Añade aserciones para verificar el comportamiento esperado después de presionar la tecla RIGHT
    }

}
