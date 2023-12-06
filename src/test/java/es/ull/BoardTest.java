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
    public void testSetSize() {
        if(!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            assertEquals(4, board.getSize());
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
    public void testSetTiles() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            // Crear una lista de baldosas para establecer en el tablero
            List<List<Tile>> testTiles = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                List<Tile> row = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    row.add(new Tile());
                }
                testTiles.add(row);
            }

            // Establecer la lista de baldosas en el tablero
            board.setTiles(testTiles);

            // Verificar si la lista de baldosas en el tablero es la misma que la establecida
            assertEquals(testTiles, board.getTiles());
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    public void testRemTileAt() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            board.initialize();
            // Obtener la baldosa en una posición específica antes de eliminarla
            Tile tileBeforeRemoval = board.getTileAt(1, 2);

            // Eliminar la baldosa en la posición (1, 2)
            board.remTileAt(1, 2);

            // Verificar que la baldosa se haya eliminado correctamente
            Tile tileAfterRemoval = board.getTileAt(1, 2);
            assertTrue(tileAfterRemoval.isEmpty()); // Comprobar si la baldosa está vacía después de la eliminación
            assertNotEquals(tileBeforeRemoval, tileAfterRemoval); // Comprobar que las baldosas antes y después de la eliminación son diferentes
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

    @Test
    void testAddEmptyTilesFirst() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            List<Tile> tiles = new ArrayList<>();
            tiles.add(new Tile(2));
            tiles.add(new Tile(4));

            // Agregar baldosas vacías al principio
            List<Tile> merged = board.addEmptyTilesFirst(tiles);

            // Verificar si las baldosas vacías se han agregado correctamente al principio
            assertEquals(4, merged.size()); // El tamaño debe ser igual al tamaño del tablero (4)
            for (int i = 0; i < tiles.size()/2; i++) {
                assertTrue(merged.get(i).isEmpty()); // Las primeras baldosas deben ser vacías
            }
            for (int i = tiles.size()/2; i < merged.size(); i++) {
                assertFalse(merged.get(i).isEmpty()); // Las baldosas adicionales no deben ser vacías
            }
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    void testAddEmptyTilesLast() {
        if (!GraphicsEnvironment.isHeadless()) {
            Board board = new Board(4);
            List<Tile> tiles = new ArrayList<>();
            tiles.add(new Tile(2));
            tiles.add(new Tile(4));

            // Agregar baldosas vacías al final
            List<Tile> merged = board.addEmptyTilesLast(tiles);

            // Verificar si las baldosas vacías se han agregado correctamente al final
            assertEquals(4, merged.size()); // El tamaño debe ser igual al tamaño del tablero (4)
            for (int i = 0; i < tiles.size()/2; i++) {
                assertTrue(!merged.get(i).isEmpty()); // Las primeras baldosas no deben ser vacías
            }
            for (int i = tiles.size()/2; i < merged.size(); i++) {
                assertTrue(merged.get(i).isEmpty()); // Las baldosas adicionales deben ser vacías
            }

        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }


}
    
