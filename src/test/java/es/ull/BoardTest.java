package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
public class BoardTest {
    @Test
    public void constructorTest() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            assertTrue(board instanceof Board);
            assertNotNull(board);
            assertEquals(4, board.getSize());
            assertNotNull(board.getTiles());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }

    }

    @Test
    public void testSetDificultad() {
        if(!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            board.setDificultad(2);
            assertEquals(2, board.getDificultad());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void testSetModo() {
        if(!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            board.setModo(1);
            assertEquals(1, board.getModo());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void initializeTest() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            board.initialize();
            assertEquals(4, board.getSize());
            assertNotNull(board.getTiles());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    public void testGetTiles() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            List<Tile> tiles = new ArrayList<>();
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            assertNotNull(tiles);
            assertEquals(4, tiles.size());
            assertEquals(tiles, board.getTiles());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        } 
    }

    @Test
    void testMergeTiles() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            List<Tile> tiles = new ArrayList<>();
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            assertNotNull(tiles);
            assertEquals(4, tiles.size());
            List<Tile> mergedTiles = board.mergeTiles(tiles);
            assertEquals(2, tiles.size());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    void testMergeTiles1() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            List<Tile> tiles = new ArrayList<>();
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            tiles.add(new Tile(2));
            assertNotNull(tiles);
            assertEquals(4, tiles.size());
            List<Tile> mergedTiles = board.mergeTilesMode1(tiles);
            assertEquals(2, tiles.size());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

}
    
