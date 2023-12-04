package es.ull;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void SetUp() {
        board = new Board(4);
        Board.setDificultad(2);
    }
    
    @Test
    public void testInitialBoardSetup() {

        // Verify that the board is initialized with the correct size
        assertEquals(4, board.getSize());

        // Verify that the board is initialized with empty tiles
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                assertEquals(0, board.getTileAt(i, j).getValue());
            }
        }
    }

    @Test
    public void testGetDificultad() {
        assertEquals(2, board.getDificultad());
    }
}
