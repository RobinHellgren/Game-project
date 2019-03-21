package game;
//Actor subclass for the player
public class Player extends Actor{
	//booleans to check the players proggress
	private boolean foundDairy;
	private boolean defeatedGoblin;
	private boolean defeatedThrone;
	private boolean knowsAnswerToRiddle;
	private boolean clearedTreasureRoom;
	public Player() {
		//set the actor type to player
		this.type = ActorType.PLAYER;
	}
	//function that resets the players stats to a new player
	public void resetPLayerStats() {
		health = 0;
		strength = 0;
		agility = 0;
		smarts = 0;
	}
	//Getters and setters
	public String getPlayerClass() {
		return playerClass;
	}
	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public boolean isFoundDairy() {
		return foundDairy;
	}

	public void setFoundDairy(boolean foundDairy) {
		this.foundDairy = foundDairy;
	}

	public boolean isDefeatedGoblin() {
		return defeatedGoblin;
	}

	public void setDefeatedGoblin(boolean defeatedGoblin) {
		this.defeatedGoblin = defeatedGoblin;
	}

	public boolean isDefeatedThrone() {
		return defeatedThrone;
	}

	public void setDefeatedThrone(boolean defeatedThrone) {
		this.defeatedThrone = defeatedThrone;
	}

	public boolean isKnowsAnswerToRiddle() {
		return knowsAnswerToRiddle;
	}

	public void setKnowsAnswerToRiddle(boolean knowsAnswerToRiddle) {
		this.knowsAnswerToRiddle = knowsAnswerToRiddle;
	}

	public boolean isClearedTreasureRoom() {
		return clearedTreasureRoom;
	}

	public void setClearedTreasureRoom(boolean clearedTreasureRoom) {
		this.clearedTreasureRoom = clearedTreasureRoom;
	}	
}
