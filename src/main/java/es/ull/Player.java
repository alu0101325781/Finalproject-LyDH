package es.ull;

/**
 * Class Player that handles the player
 */
public class Player {
  private String name;
  private int score;
  
  /**
   * Constructor of the class Player
   * @param name Name of the player
   * @param score Score of the player
   */
  public Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
  
  /**
   * Get the name of the player
   * @return Name of the player
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Get the score of the player
   * @return Score of the player
   */
  public int getScore() {
    return this.score;
  }
}
