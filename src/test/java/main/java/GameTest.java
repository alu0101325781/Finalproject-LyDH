package main.java;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    @Test
    public void testGame() {
        Game game = new Game();
        assertTrue(game instanceof Game);
    }
}