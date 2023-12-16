/**
 * Initializes the game
 */
public class Main {
	
	public static void main(String[] args) {
		try {
			new Menu();
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		        		
	}
}