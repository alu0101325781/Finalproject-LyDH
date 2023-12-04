package es.ull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        // Configura las dependencias necesarias antes de crear el tablero
        ColorScheme colorScheme = new ColorScheme();
        Controls controls = new Controls();
        Window window = new Window("2048");
        // Agrega cualquier otra configuración necesaria para las dependencias

        // Ahora puedes configurar el tablero
        board = new Board(4);

        // Configura las dependencias en la clase Game
        Game.COLORS = colorScheme;
        Game.CONTROLS = controls;
        Game.WINDOW = window;
        // Ajusta cualquier otra dependencia en la clase Game
    }

    @Test
    public void testInitialBoardSetup() {
        // Comprueba que el tablero se ha creado correctamente
        assertEquals(4, board.getSize());
    }

    @Test
    public void testGetDificultad() {
        // Comprueba que el tablero se ha creado correctamente
        assertEquals(4, board.getSize());
    }
}
