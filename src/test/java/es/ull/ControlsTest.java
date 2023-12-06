package es.ull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.KeyEvent;

public class ControlsTest {

    private Controls controls;

    @BeforeEach
    public void setUp() {
        // Puedes inicializar aquí los objetos necesarios antes de cada prueba
        controls = new Controls();
    }

    @Test
    public void testKeyReleased() {
        // Puedes hacer pruebas relacionadas con keyReleased si es necesario
        // En este caso, como el método está vacío, la prueba puede ser simple
        assertDoesNotThrow(() -> controls.keyReleased(null));
    }

    @Test
    public void testKeyTyped() {
        // Puedes hacer pruebas relacionadas con keyTyped si es necesario
        // En este caso, como el método está vacío, la prueba puede ser simple
        assertDoesNotThrow(() -> controls.keyTyped(null));
    }

    @Test
    public void testKeyPressed_MoveUp() {
        // Simula la pulsación de la tecla UP
        KeyEvent event = new KeyEvent(Game.WINDOW, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, 'W');

        // Puedes realizar pruebas para asegurar que la llamada a moveUp() se realiza correctamente
        assertDoesNotThrow(() -> controls.keyPressed(event));
        // Agrega más aserciones según sea necesario
    }

    @Test
    public void testKeyPressed_MoveDown() {
        // Simula la pulsación de la tecla DOWN
        KeyEvent event = new KeyEvent(Game.WINDOW, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, 'S');

        // Puedes realizar pruebas para asegurar que la llamada a moveDown() se realiza correctamente
        assertDoesNotThrow(() -> controls.keyPressed(event));
        // Agrega más aserciones según sea necesario
    }

    // Repite para las teclas LEFT, RIGHT, ESCAPE, y otros casos si es necesario

    @Test
    public void testBind() {
        // Puedes probar que el método bind() agrega el KeyListener correctamente
        assertDoesNotThrow(() -> controls.bind());
        // Agrega más aserciones según sea necesario
    }

    @Test
    public void testUnbind() {
        // Puedes probar que el método unbind() elimina el KeyListener correctamente
        assertDoesNotThrow(() -> controls.unbind());
        // Agrega más aserciones según sea necesario
    }
}
