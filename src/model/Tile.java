package model;

public class Tile {

	private boolean hasCharacter = false;
	private boolean canEncounter = true;
	
	public boolean hasCharacter()
	{
		return hasCharacter;
	}
	
	public void setHasCharacter(boolean hasCharacter)
	{
		this.hasCharacter = hasCharacter;
	}
	
	public boolean getCanEncounter(){
		return canEncounter;
	}
}
