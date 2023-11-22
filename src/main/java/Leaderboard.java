package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private static final String FILENAME = "leaderboard.txt";
    private static final String SEPARATOR = " ";

    /**
     * Load the leaderboard from the file
     *
     * @return List of players
     */
    static List<Player> loadLeaderboard() {
        List<Player> players = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                if (parts.length >= 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    players.add(new Player(name, score));
                } else {
                    System.out.println("Error: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            createFile();
        } catch (IOException e) {
            handleIOException(e);
        }
        return players;
    }

    /**
     * Save the leaderboard to the file
     *
     * @param players List of players
     */
    private static void saveLeaderboard(List<Player> players) {
        try (FileWriter fw = new FileWriter(FILENAME)) {
            for (Player player : players) {
                fw.write(player.getName() + SEPARATOR + player.getScore() + "\n");
            }
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Create the file if it does not exist
     */
    private static void createFile() {
        File file = new File(FILENAME);
        try {
            file.createNewFile();
        } catch (IOException e) {
            handleIOException(e);
        }
    }

    /**
     * Handle IOException, log or handle the exception according to your needs
     *
     * @param e IOException
     */
    private static void handleIOException(IOException e) {
        if (DEBUG_MODE) {
            // Log the exception or handle it in a way suitable for debugging
            e.printStackTrace();
        } else {
            // Handle the exception in a way suitable for a release build
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Add a player to the leaderboard
     *
     * @param player Player to add
     */
    public static void addPlayer(Player player) {
        List<Player> players = loadLeaderboard();
        players.add(player);
        saveLeaderboard(players);
    }

    /**
     * Sort the players by score
     */
    public static void sortPlayers() {
        List<Player> players = loadLeaderboard();
        players.sort((p1, p2) -> p2.getScore() - p1.getScore());
        saveLeaderboard(players);
    }

    /**
     * Print the leaderboard
     *
     * @param players List of players
     */
    public static void printLeaderboard(List<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + SEPARATOR + player.getScore());
        }
    }
}