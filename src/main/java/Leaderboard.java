package main.java;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Leaderboard
 */
public class Leaderboard {
  private static final String FILENAME = "leaderboard.txt";

  public static List<Player> loadLeaderboard() {
    List<Player> players = new ArrayList<>();
    
    try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(" ");
        if (parts.length >= 2) {
          String name = parts[0];
          int score = Integer.parseInt(parts[1]);
          players.add(new Player(name, score));
        } else {
          System.out.println("Error: " + line);
        }
      }
    } catch (FileNotFoundException e) {
      File file = new File(FILENAME);
      try {
        file.createNewFile();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return players;
  }

  public static void saveLeaderboard(List<Player> players) {
    try (FileWriter fw = new FileWriter(FILENAME)) {
      for (Player player : players) {
        fw.write(player.getName() + " " + player.getScore() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void addPlayer(Player player) {
    List<Player> players = loadLeaderboard();
    players.add(player);
    saveLeaderboard(players);
  }

  public static void sortPlayers() {
    List<Player> players = loadLeaderboard();
    players.sort((p1, p2) -> p2.getScore() - p1.getScore());
    saveLeaderboard(players);
  }

  public static void printLeaderboard(List<Player> players) {
    for (Player player : players) {
      System.out.println(player.getName() + " " + player.getScore());
    }
  }

}