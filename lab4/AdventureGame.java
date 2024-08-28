package labs.lab4;
import java.awt.Point;
import java.util.List;
/**
* A class for an adventure game with a player, traps, and jet packs. The game
* world measures 10 x 10, and the center of the world is at coordinates 0, 0.
*/
public class AdventureGame {
	// ADD INSTANCE VARIABLES HERE
	
	private Integer[][] board;
	private int dir; // 0: North, 1: East, 2: South, 3: West
	private Point location;
	private int numJetpacks;
	private int numMoves;
	private int size;
	private int centx;
	private int centy;
	
	
	/**
	* Constructs a new game with player location 0, 0 (in the center of the
	world)
	* facing north, with the traps and jet packs given
	*
	* @param traps list of locations of traps (assume all within world
	bounds,
	* and not at 0, 0)
	* @param jetPacks list of locations of jet packs (assume all within world
	* bounds, and not at 0, 0)
	*/
	public AdventureGame(List<Point> traps, List<Point> jetPacks) {
		size = 11;
		board = new Integer[size][size];
		location = new Point(0,0);
		dir = 0;
		numJetpacks = 0;
		numMoves = 0;
		
		centx = size/2;
		centy = size/2;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (Point p : traps) { 						//traps: 1
					if (p.x == i-centx && p.y == centy-j) {
						board[i][j] = 1;
					}
				}
				for (Point p : jetPacks) {						//jet packs: 2
					if (p.x == i-centx && p.y == centy-j) {
						if (board[i][j] != null) {
							board[i][j] = 3;					// both trap and jet pack: 3
						} else {
						board[i][j] = 2;
						}
					}
				}
			}
		}
	}
	/**
	* Turns the player to the left
	*/
	public void playerTurnLeft() {
		if (dir == 0) {
			dir = 3;
		} else {
			dir--;
		}
	}
	/**
	* Turns the player to the right
	*/
	public void playerTurnRight() {
		if (dir == 3) {
			dir = 0;
		} else {
			dir++;
		}
	}
	/**
	* Moves the player one step in the direction they're facing, as long as the
	* move is a valid one (within the bounds of the world)
	*/
	public void movePlayer() {
		switch (dir) {
		case 0:
			if (location.y == 5) {					//moves out of board
				break;
			}
			
			location.move(location.x, location.y+1);
			printSpot();
			numMoves++;
			break;
			
		case 1:
			if (location.x == 5) {
				break;
			}
			
			location.move(location.x+1, location.y);
			printSpot();
			numMoves++;
			break;
			
		case 2:
			if (location.y == -5) {
				break;
			}
			
			location.move(location.x, location.y-1);
			printSpot();
			numMoves++;
			break;
			
		case 3:
			if (location.x == -5) {
				break;
			}
			
			location.move(location.x-1, location.y);
			printSpot();
			numMoves++;
			break;
			
		}
		
		if (numMoves == 30) {
			System.out.print("You win!");
		}
	}
	
	private int checkSpot() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (location.x == i-centx && location.y == centy-j) {
					if (board[i][j] == null) {
						return 0;
					} else if (board[i][j] == 1) {
						return 1;
					} else if (board[i][j] == 2) {
						if (numJetpacks < 3) {
							board[i][j] = null;
						}
						return 2;
					} else if (board[i][j] == 3) {
						if (numJetpacks < 3) {
							board[i][j] = 1;
						}
						return 3;
					}
				}
			}
		}
		return 0;
	}
	
	private void printSpot() {
		int spot = checkSpot();
		//check trap or jet pack
		if (spot == 1) {
			if (numJetpacks > 0) {				// use jet pack
				numJetpacks--;
				System.out.print("Fell into a trap! Used jet pack! ");
			} else {
				System.out.print("Fell into a trap! You lose!");
			}
		} else if (spot == 2) {
			if (numJetpacks < 3) {
				numJetpacks++;
				System.out.print("Picked up jet pack! ");
			}
		} else if (spot == 3) {
			if (numJetpacks == 3) {
				System.out.print("Fell into a trap! Used jet pack! Picked up jet pack! ");
			} else {
				System.out.print("Picked up jet pack! Fell into a trap! Used jet pack! ");
			}
		}
	}
	
	/**
	* Returns the player's current location
	*
	* @return the player's current location
	*/
	public Point getPlayerLocation() {
		return location; // FIX ME
	}
	/**
	* Returns the direction in which the player is currently facing
	* ("NORTH", "SOUTH", "EAST", OR "WEST")
	*
	* @return the direction in which the player is currently facing
	*/
	public String getPlayerDirection() {
		switch (dir) {
		case 0:
			return "NORTH";
		case 1:
			return "EAST";
		case 2:
			return "SOUTH";
		case 3:
			return "WEST";
		}
		return "";
	}
	/**
	* Returns the number of moves the player has taken
	*
	* @return the number of moves the player has taken
	*/
	public int getNumMovesMade() {
		return numMoves; // FIX ME
	}
}