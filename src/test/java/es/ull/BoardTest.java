package es.ull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(4);
    }
    @Test
    public void constructorTest() {
        assertNotNull(board);
        assertEquals(4, board.getSize());
        assertNotNull(board.getTiles());
    }

    @Test
    public void initializeTest() {
        board.initialize();
        assertEquals(4, board.getSize());
        assertNotNull(board.getTiles());
    }

    @Test
    void testMergeTiles() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(2));
        tiles.add(new Tile(2));
        tiles.add(new Tile(2));
        tiles.add(new Tile(2));
        assertNotNull(tiles);
        assertEquals(4, tiles.size());
        List<Tile> mergedTiles = board.mergeTiles(tiles);
        assertEquals(2, tiles.size());
    }
}
