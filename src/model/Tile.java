package model;

public abstract class Tile {

	private boolean hasCharacter = false;
	private String tileName;
	private boolean canEncounter;
	private boolean solid;
	
	public Tile(String name, boolean encounter, boolean isSolid){
		tileName = name;
		canEncounter = encounter;
		solid = isSolid;
	}
	
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
	
	public boolean getSolid(){
		return solid;
	}
	
	public String getTileName(){
		return tileName;
	}
	
	//public abstract void setSolid(boolean toSet);
}
