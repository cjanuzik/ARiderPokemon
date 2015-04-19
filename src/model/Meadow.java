package model;

import model.Tiles.MeadowGrass;
import model.Tiles.TallGrass;
import model.Tiles.TreeBottomLeft;
import model.Tiles.TreeBottomRight;
import model.Tiles.TreeLeft;
import model.Tiles.TreeRight;
import model.Tiles.TreeTopLeft;
import model.Tiles.TreeTopRight;

public class Meadow {
    private Tile meadowLayout[][];
    
	public Meadow(){
		addTiles();
    }
	
	private void addTiles(){
		meadowLayout = new Tile[][]{
			{new MeadowGrass(), new TallGrass(), new TreeTopLeft(), new TreeTopRight()},
			{new MeadowGrass(), new MeadowGrass(), new TreeLeft(), new TreeRight()},
			{new TallGrass(), new TallGrass(), new TreeBottomLeft(), new TreeBottomRight()}
		};
	}
}
