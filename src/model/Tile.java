package model;
/**
 * this class sets the basic characteristics of the tiles in the map
 * @author Aakash
 *
 */
public abstract class Tile {
	
	private boolean hasCharacter = false;
	private String tileName;
	private boolean canEncounter;
	private boolean solid;
	private boolean hasSurf = false;
	private boolean hasRockSmash = false;
	private boolean hasRock = false;
	
	/**
	 * initializes the values using the parameters
	 * @param name
	 * @param encounter
	 * @param isSolid
	 */
	public Tile(String name, boolean encounter, boolean isSolid){
		tileName = name;
		canEncounter = encounter;
		solid = isSolid;
	}
	/**
	 * returns if the tile has a character
	 * @return
	 */
	public boolean hasCharacter()
	{
		return hasCharacter;
	}
	/**
	 * updates if the tile does or doesn't have the character to the value passed as parameter
	 * @param hasCharacter
	 */
	public void setHasCharacter(boolean hasCharacter)
	{
		this.hasCharacter = hasCharacter;
	}
	/**
	 * returns if the pokemon could be encountered in the tile
	 * @return canEncounter
	 */
	public boolean getCanEncounter(){
		return canEncounter;
	}
	/**
	 * returns if the tile is solid or not
	 * @return soldi
	 */
	public boolean getSolid(){
		return solid;
	}
	
	/**
	 * returns the tile name
	 * @return tileName
	 */
	public String getTileName(){
		return tileName;
	}
	
	/**
	 * sets if the tile has surf power on it to the value passed as parameter
	 * @param setSurf
	 */
	public void setHasSurf(boolean setSurf){
		hasSurf = setSurf;
		if(setSurf)
			solid = true;
		else
			solid = false;
	}
	/**
	 * sets if the tile has rock smash power on it to the value passed as parameter
	 * @param setRockSmash
	 */
	public void setHasRockSmash(boolean setRockSmash){
		hasRockSmash = setRockSmash;
		if(setRockSmash)
			solid = true;
		else
			solid = false;
	}
	/**
	 * sets if the tile has rock on it to the value passed as parameter
	 * @param toSet
	 */
	public void setHasRock(boolean toSet){
		hasRock = toSet;
		if(toSet)
			solid = true;
		else
			solid = false;
	}
	/**
	 * returns if the tile has surfAbility power on it
	 * @return hasSurf
	 */
	public boolean getHasSurf(){
		return hasSurf;
	}
	/**
	 * returns if the tile has rockSmash power on it
	 * @return
	 */
	public boolean getHasRockSmash(){
		return hasRockSmash;
	}
	/**
	 * returns if the tile has rock on it
	 * @return
	 */
	public boolean getHasRock(){
		return hasRock;
	}
}
