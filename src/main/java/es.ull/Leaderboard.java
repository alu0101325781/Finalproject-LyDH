import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
    private static final String FILENAME = "leaderboard.txt";
    private static final String SEPARATOR = " ";
    private static final String ERROR = "Error: ";

    Leaderboard(){}

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
                    System.out.println(ERROR + line);
                }
            }
        } catch (FileNotFoundException e) {
            createFile();
        } catch (IOException e) {
            System.out.println(ERROR + e.getMessage());
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
            System.out.println(ERROR + e.getMessage());
        }
    }

    /**
     * Create the file if it does not exist
     */
     private static void createFile() {
        File file = new File(FILENAME);
        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("File created successfully.");
                // Realiza alguna acción adicional si es necesario
            } else {
                System.out.println("File already exists.");
                // Realiza alguna acción adicional si es necesario
            }
        } catch (IOException e) {
            System.out.println(ERROR + e.getMessage());
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

    /**
     * Clear the leaderboard
     */
    public static void clearLeaderboard() {
        List<Player> players = new ArrayList<>();
        saveLeaderboard(players);
    }
}
