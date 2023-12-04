package main.java;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    @Test
    public void testGame() {
        Game game = new Game();
        assertEquals("Game", game.getClass().getName());
    }
}
