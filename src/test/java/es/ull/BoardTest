package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.*;
import java.awt.event.KeyEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;

public class BoardTest {
    public void testInitialBoardSetup() {
        Board board = new Board(4);

        // Verify that the board is initialized with the correct size
        assertEquals(4, board.getSize());

        // Verify that the board is initialized with empty tiles
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                assertEquals(0, board.getTileAt(i, j).getValue());
            }
        }
    }
}
