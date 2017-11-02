package caveExplorer;

public class CaveRoom {
	
	private String description;
	private String directions; //tells you which doors can be used
	private String contents; //a symbol showing you what is in the room
	private String defaultContents; //what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		//Note: Arrays are instantiated with 'null' values
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	
	/**
	 * for every Door in doors[] that is not null,
	 * this method appends a String describing the door and 
	 * where it is
	 * e.x. 
	 * 		-- There is a (passage) to (the South) --
	 * 		-- There is a (passage to (the East) --
	 * If there are no doors that are not null, this sets directions to:
	 *		-- " There is no way out. You are trapped in this room" --
	 *
	 */

	
	public void setDirections() {	
		directions = "";
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				directions += "There is a "+ doors[i].getDescription() + " to the " + toDirection(i) + ". " + doors[i].getDetails() + "\n";
			}
		}
		if(directions.length() == 0) {
			directions = "There is no way out. You are trapped in this room.";
		}
	}
	
	/**
	 * converts an int to a direction
	 * 0 -> "the North"
	 * 1 -> "the East"
	 * hint: complete this method without using an if statement
	 * @param dir
	 * @return
	 */
	
	public static String toDirection(int dir) {
		String[] directions = {"the North", "the East", "the South", "the West"};
		return directions[dir];
	}
	
	public void enter() {
		this.contents = "X";
	}
	
	public void leave() {
		this.contents = defaultContents;
	}
	
	/**
	 * 
	 * This is how we join rooms together.
	 * It gives this room access to anotherRoom and vice-versa
	 * It also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	/**
	 * returns the OPPOSITE direction
	 * @param direction
	 * @return
	 */

	public static int oppositeDirection(int direction) {
		return (direction + 2) % 4;
	}

	public void addRoom(int direction, CaveRoom caveRoom, Door door) {
		borderingRooms[direction] = caveRoom;
		doors[direction] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w','a',s,' or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		int direction = "wdsa".indexOf(input);
		goToRoom(direction);
	}
	
	/**
	 * returns true if w,a,s, or d is the input (NO IF STATEMENTS)
	 * @param input
	 * @return
	 */
	
	private boolean isValid(String input) {
		String inputChars = "wasd";
		return inputChars.indexOf(input) >= 0 && input.length() == 1;
	}
	
	/**
	 * THIS IS WHERE YOU EDIT YOUR CAVES
	 */
	
	public static void setUpCaves() {
		//1. Determine size of caves
		CaveExplorer.caves = new NPCRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves; //creates a shortcut for accessing CaveExplorer.caves
		//2. Populate with default caves
		for(int row = 0; row < c.length; row++) {
			for(int col = 0; col < c[row].length; col++) {
				c[row][col] = new NPCRoom("This cave has coordinates ("+row+","+col+")");
			}
		}
		//3. Replace some default rooms with custom rooms (SAVE FOR LATER)
		NPC testNPC = new NPC();
		testNPC.setPosition(1,2);
		CaveExplorer.npcs = new NPC[1];
		CaveExplorer.npcs[0] = testNPC;
		
		//4. Set starting room
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		//5. Set up doors
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
	}

	public void goToRoom(int direction) {
		//make sure there is a room to go to
		if(borderingRooms[direction] != null && doors[direction] != null && doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
		}else {
			System.err.println("You can't do that!");
		}
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Door getDoor(int direction) {
		// TODO Auto-generated method stub
		return doors[direction];
	}

}