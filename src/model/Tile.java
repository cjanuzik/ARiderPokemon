package model;

public abstract class Tile {

	private boolean hasCharacter = false;
	private String tileName;
	private boolean canEncounter;
	private boolean solid;
	private boolean hasSurf = false;
	private boolean hasRockSmash = false;
	
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
	
	public void setHasSurf(boolean setSurf){
		hasSurf = setSurf;
	}
	
	public void setHasRockSmash(boolean setRockSmash){
		hasRockSmash = setRockSmash;
		if(setRockSmash)
			solid = true;
		else
			solid = false;
	}
	
	public boolean getHasRockSmash(){
		return hasRockSmash;
	}
}
