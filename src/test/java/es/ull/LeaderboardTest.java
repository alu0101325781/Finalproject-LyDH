package es.ull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

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
}
