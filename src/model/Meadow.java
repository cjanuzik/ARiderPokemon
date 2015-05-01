package model;


import model.Tiles.FenceBottom;
import model.Tiles.FenceBottomLeft;
import model.Tiles.FenceBottomRight;
import model.Tiles.FenceRight;
import model.Tiles.FenceTopLeft;
import model.Tiles.FenceTopRight;
import model.Tiles.MeadowGrass;
import model.Tiles.TallGrass;
import model.Tiles.TreeBottomLeft;
import model.Tiles.TreeBottomRight;
import model.Tiles.TreeLeft;
import model.Tiles.TreeRight;
import model.Tiles.MidTreeTopLeft;
import model.Tiles.MidTreeTopRight;
import model.Tiles.TreeTopLeft;
import model.Tiles.TreeTopRight;
import model.Tiles.Water;
import model.Tiles.WaterBottom;
import model.Tiles.WaterBottomLeft;
import model.Tiles.WaterBottomRight;
import model.Tiles.WaterLeft;
import model.Tiles.WaterRight;
import model.Tiles.WaterTop;
import model.Tiles.WaterTopLeft;
import model.Tiles.WaterTopRight;

public class Meadow {
private Tile[][] meadow;

    public Meadow(){
	    makeMeadow();
    }

    private void makeMeadow(){
    	meadow = new Tile[][] {
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(),		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(),	new TreeBottomRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(),		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterTopLeft(), 	new WaterTop(), 		new WaterTop(), 		new WaterTop(), 		new WaterTopRight(), 	new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterBottomLeft(), 	new WaterBottom(), 		new WaterBottom(), 		new WaterBottom(), 		new WaterBottomRight(), new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(),		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new WaterTopLeft(), 	new WaterTop(), 		new WaterTop(), 		new WaterTop(), 		new WaterTop(), 		new WaterTop(),			new WaterTop(), 		new WaterTopRight(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new WaterLeft(), 		new Water(), 			new Water(), 			new Water(), 			new Water(), 			new Water(), 			new Water(), 			new WaterRight(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new WaterLeft(), 		new Water(), 			new Water(), 			new Water(), 			new Water(), 			new Water(), 			new Water(), 			new WaterRight(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new TreeBottomLeft(),	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new MeadowGrass(),		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new WaterLeft(), 		new Water(), 			new Water(), 			new Water(), 			new Water(), 			new Water(), 			new Water(), 			new WaterRight(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight()},
    			{new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new WaterBottomLeft(), 	new WaterBottom(), 		new WaterBottom(), 		new WaterBottom(), 		new WaterBottom(), 		new WaterBottom(), 		new WaterBottom(), 		new WaterBottomRight(), new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterTopLeft(), 	new WaterTop(), 		new WaterTop(), 		new WaterTop(),  		new WaterTop(), 		new WaterTopRight(), 	new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass()},
    			{new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterLeft(), 		new Water(), 			new Water(), 			new Water(),  			new Water(), 			new WaterRight(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass()},
    			{new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterLeft(), 		new Water(), 			new Water(), 			new Water(),  			new WaterBottom(), 		new WaterBottomRight(), new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass()},
    			{new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterLeft(), 		new Water(), 			new Water(), 			new WaterRight(),  		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass()},
    			{new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterLeft(), 		new Water(), 			new Water(), 			new WaterRight(),  		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass()},
    			{new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterLeft(), 		new Water(), 			new Water(), 			new WaterRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass()},
    			{new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new WaterTopLeft(), 	new WaterTop(), 		new WaterTop(), 		new WaterTop(), 		new WaterTop(), 		new WaterTop(), 		new WaterTop(), 		new WaterTopRight(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new WaterBottomLeft(), 	new WaterBottom(), 		new WaterBottom(), 		new WaterBottomRight(), new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),  	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass()},
    			{new TreeTopLeft(), 	new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new WaterBottomLeft(), 	new WaterBottom(), 		new WaterBottom(), 		new WaterBottom(),		new WaterBottom(), 		new WaterBottom(), 		new WaterBottom(),		new WaterBottomRight(), new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TallGrass(),	new TallGrass(),	new TallGrass(), 	new TallGrass(), 	new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(),		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TallGrass(), 	new TallGrass(), 	new TallGrass(), 	new TallGrass(), 	new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TallGrass(), 	new TallGrass(), 	new TallGrass(),	new TallGrass(), 	new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TallGrass(), 	new TallGrass(), 	new TallGrass(), 	new TallGrass(), 	new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new TallGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new TreeTopLeft(), 		new TreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeLeft(), 		new TreeRight(), 		new TreeLeft(),			new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight(), 	new MidTreeTopLeft(), 	new MidTreeTopRight()},
    			{new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight(), 		new TreeLeft(), 		new TreeRight()},
    			{new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 		new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new MeadowGrass(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight(), 	new TreeBottomLeft(), 	new TreeBottomRight()},
    	};
    }
    
    public Tile[][] getMeadow(){
    	return meadow;
    }
}
