import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderboardTest {
      
      private Leaderboard leaderboard = new Leaderboard();

      @BeforeEach
      public void setUp() {
          leaderboard.clearLeaderboard();
      }

      @Test
      public void testConstructor() {
          // Arrange
          String playerName = "Charlie";
          int initialScore = 75;
  
          // Act
          Player player = new Player(playerName, initialScore);
  
          // Assert
          assertNotNull(player);
          assertEquals(playerName, player.getName());
          assertEquals(initialScore, player.getScore());
      }
  
      @Test
      public void testGetName() {
          // Arrange
          String playerName = "Alice";
          Player player = new Player(playerName, 100);
  
          // Act
          String name = player.getName();
  
          // Assert
          assertEquals(playerName, name);
      }
  
      @Test
      public void testGetScore() {
          // Arrange
          int initialScore = 50;
          Player player = new Player("Bob", initialScore);
  
          // Act
          int score = player.getScore();
  
          // Assert
          assertEquals(initialScore, score);
      }

      @Test
      public void testLoadLeaderboard() {
          // Arrange
          Player player1 = new Player("Alice", 100);
          Player player2 = new Player("Bob", 50);
          leaderboard.addPlayer(player1);
          leaderboard.addPlayer(player2);

          // Act
          List<Player> players = leaderboard.loadLeaderboard();

          // Assert
          assertEquals(2, players.size());
          assertEquals(player1.getName(), players.get(0).getName());
          assertEquals(player1.getScore(), players.get(0).getScore());
          assertEquals(player2.getName(), players.get(1).getName());
          assertEquals(player2.getScore(), players.get(1).getScore());
      }

    @Test
    public void testAddPlayer() {
        // Arrange
        Player player = new Player("John", 80);

        // Act
        leaderboard.addPlayer(player);
        List<Player> players = leaderboard.loadLeaderboard();

        // Assert
        assertEquals(1, players.size());
        assertEquals(player.getName(), players.get(0).getName());
        assertEquals(player.getScore(), players.get(0).getScore());
    }

    @Test
    public void testSaveLeaderboard() {
        // Arrange
        Player player1 = new Player("Alice", 100);
        Player player2 = new Player("Bob", 50);
        List<Player> players = Arrays.asList(player1, player2);

        // Act
        leaderboard.saveLeaderboard(players);
        List<Player> loadedPlayers = leaderboard.loadLeaderboard();

        // Assert
        assertEquals(2, loadedPlayers.size());
        assertEquals(player1.getName(), loadedPlayers.get(0).getName());
        assertEquals(player1.getScore(), loadedPlayers.get(0).getScore());
        assertEquals(player2.getName(), loadedPlayers.get(1).getName());
        assertEquals(player2.getScore(), loadedPlayers.get(1).getScore());
    }

    @Test
    public void testClearLeaderboard() {
        // Arrange
        Player player = new Player("Charlie", 75);
        leaderboard.addPlayer(player);

        // Act
        leaderboard.clearLeaderboard();
        List<Player> players = leaderboard.loadLeaderboard();

        // Assert
        assertEquals(0, players.size());
    }

    @Test
    public void testSortPlayers() {
        // Arrange
        Player player1 = new Player("Alice", 100);
        Player player2 = new Player("Bob", 50);
        Player player3 = new Player("Charlie", 75);
        List<Player> unsortedPlayers = Arrays.asList(player1, player2, player3);

        Leaderboard leaderboard = new Leaderboard();
        leaderboard.saveLeaderboard(unsortedPlayers);

        // Act
        leaderboard.sortPlayers();
        List<Player> sortedPlayers = leaderboard.loadLeaderboard();

        // Assert
        assertEquals("Alice", sortedPlayers.get(0).getName());
        assertEquals(100, sortedPlayers.get(0).getScore());
        assertEquals("Charlie", sortedPlayers.get(1).getName());
        assertEquals(75, sortedPlayers.get(1).getScore());
        assertEquals("Bob", sortedPlayers.get(2).getName());
        assertEquals(50, sortedPlayers.get(2).getScore());
    }

    @Test
    public void testPrintLeaderboard() {
        // Arrange
        Player player1 = new Player("Alice", 100);
        Player player2 = new Player("Bob", 50);
        Player player3 = new Player("Charlie", 75);
        List<Player> players = Arrays.asList(player1, player2, player3);

        // Redirect System.out to capture the printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        Leaderboard.printLeaderboard(players);

        // Assert
        String expectedOutput = "Alice 100\nBob 50\nCharlie 75\n";
        String actualOutput = outContent.toString().replaceAll("\\s+$", "") + "\n"; // Agregar un retorno de carro al final
        actualOutput = actualOutput.replace(System.lineSeparator(), "\n"); // Normalizar saltos de línea
        expectedOutput = expectedOutput.replace(System.lineSeparator(), "\n"); // Normalizar saltos de línea

        System.out.println("Expected: " + expectedOutput);
        System.out.println("Actual  : " + actualOutput);
        assertEquals(expectedOutput, actualOutput, "Actual output: " + outContent.toString());


        // Restore the original System.out
        System.setOut(System.out);
    }

    private static final String FILENAME = "testfile.txt";
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Test
    public void testCreateFile() {
        // Arrange
        File file = new File(FILENAME);
        System.setOut(new PrintStream(outContent));

        // Act
        Leaderboard.createFile();

        // Assert
        assertTrue(file.exists(), "File should exist after createFile");
        assertDoesNotThrow(() -> file.createNewFile(), "File should be created");

        // Restaurar la salida original de la consola
        System.setOut(originalOut);

        // Verificar que se haya impreso el mensaje de error esperado
        assertFalse(outContent.toString().contains("Error creating file:"), "Error message should be printed");
    }

}
