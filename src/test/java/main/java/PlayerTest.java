package main.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;

public class PlayerTest {

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
}
