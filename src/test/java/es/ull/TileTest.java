package es.ull;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class TileTest {
    
    @Test
    public void testConstructorWithValue() {
        int value = 4;

        Tile tile = new Tile(value);

        assertNotNull(tile);
        assertEquals(value, tile.getValue());
    }

    
    @Test
    public void testConstructorDefault() {
        Tile tile = new Tile();
        assertNotNull(tile);
    }

    @Test
    public void testSetValue() {
        // Arrange
        int value = 8;
        Tile tile = new Tile(0);

        // Act
        tile.setValue(value);

        // Assert
        assertEquals(value, tile.getValue());
    }

    @Test
    public void testSetPosition() {
        // Arrange
        int row = 2;
        int col = 3;
        Tile tile = new Tile(0);

        // Act
        tile.setPosition(row, col);

        // Assert
        assertEquals(row, tile.getRow());
        assertEquals(col, tile.getCol());
    }

    @Test
    public void testMerging() {
        // Arrange
        Tile tile = new Tile(4);

        // Act
        int result = tile.merging();

        // Assert
        assertEquals(8, result);
    }

    @Test
    public void testHasMoved() {
        // Arrange
        Tile tile = new Tile(2, 1, 1);

        // Act
        boolean moved = tile.hasMoved(1, 1);

        // Assert
        assertFalse(moved);
    }

    @Test
    public void testIsEmpty() {
        // Arrange1
        Tile emptyTile = new Tile(0);
        Tile nonEmptyTile = new Tile(2);

        // Act & Assert
        assertTrue(emptyTile.isEmpty());
        assertFalse(nonEmptyTile.isEmpty());
    }
}