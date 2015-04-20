package model;

import model.Tiles.FenceBottom;
import model.Tiles.FenceBottomLeft;
import model.Tiles.FenceBottomRight;
import model.Tiles.FenceRight;
import model.Tiles.FenceTopLeft;
import model.Tiles.FenceTopRight;
import model.Tiles.MeadowGrass;
import model.Tiles.TallGrass;
import model.Tiles.Water;
import model.Tiles.WaterBottomLeft;
import model.Tiles.WaterBottomRight;
import model.Tiles.WaterTop;
import model.Tiles.WaterTopLeft;
import model.Tiles.WaterTopRight;

public class Meadow {
private int[][] tileMap;
private Tile[][] meadow;

    public Meadow(){
	    tileMap = new int[][]{
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1, 0, 0, 1, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 4, 4, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 4, 4, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 4, 4, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 4, 4, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 4, 4, 3, 3, 1, 0, 0, 1},
			{1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 4, 4, 3, 3, 1, 1, 1, 1},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
			{1, 0, 0, 1, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 1, 0, 0, 1},
			{1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
	    };
	
	    meadow = new Tile[31][32];
	    addTiles();
    }

    private void addTiles(){
    	for(int i = 0; i < 32; i++){
	        for(int j = 0; j < 31; j++){
    		    switch(tileMap[i][j]){
    		    case(0):
    		    	meadow[i][j] = new MeadowGrass();
    		        break;
    		    case(1):
    		    	addFence(i, j);
    		        break;
    		    case(2):
    		    	addWater(i, j);
    		        break;
    		    case(3):
    		    	meadow[i][j] = new TallGrass();
    		        break;
    		    }
	        }
    	}
    }
    
    private void addFence(int i, int j){
    	int bitMask = 0;
    	
    	//Fence above
    	if(tileMap[i-1][j] == 1 && i > 0){
    		bitMask += 2;
    	}
    	//Fence to the right
    	if(tileMap[i][j+1] == 1 && j < 31){
    		bitMask += 3;
    	}
    	//Fence below
    	if(tileMap[i+1][j] == 1 && i < 30){
    		bitMask += 5;
    	}
    	//Fence to the left
    	if(tileMap[i][j-1] == 1 && i > 0){
    		bitMask += 7;
    	}
    	if(bitMask == 0){
    		meadow[i][j] = new TallGrass();
    	}
    	switch(bitMask){
    	case(5):
    		meadow[i][j] = new FenceBottomLeft();
    	    break;
    	case(7):
    		meadow[i][j] = new FenceRight();
    	    break;
    	case(8):
    		meadow[i][j] = new FenceTopRight();
    	case(9):
    		meadow[i][j] = new FenceBottomRight();
    	    break;
    	case(10):
    		meadow[i][j] = new FenceBottom();
    	    break;
    	case(12):
    		meadow[i][j] = new FenceTopLeft();
    	    break;
    	}
    }
    
    private void addWater(int i, int j){
        int bitMask = 0;
    	
    	//Fence above
    	if(tileMap[i-1][j] == 2 && i > 0){
    		bitMask += 2;
    	}
    	//Fence to the right
    	if(tileMap[i][j+1] == 2 && j < 31){
    		bitMask += 3;
    	}
    	//Fence below
    	if(tileMap[i+1][j] == 2 && i < 30){
    		bitMask += 5;
    	}
    	//Fence to the left
    	if(tileMap[i][j-1] == 2 && i > 0){
    		bitMask += 7;
    	}
    	if(bitMask == 0){
    		meadow[i][j] = new TallGrass();
    	}
    	switch(bitMask){
    	case(5):
    		meadow[i][j] = new WaterBottomLeft();
    	    break;
    	case(7):
    		meadow[i][j] = new FenceRight();
    	    break;
    	case(8):
    		meadow[i][j] = new WaterTopRight();
    	case(9):
    		meadow[i][j] = new WaterBottomRight();
    	    break;
    	case(10):
    		meadow[i][j] = new FenceBottom();
    	    break;
    	case(12):
    		meadow[i][j] = new WaterTopLeft();
    	    break;
    	case(15):
    		meadow[i][j] = new WaterTop();
    	    break;
    	case(17):
    		meadow[i][j] = new Water();
    	    break;
    	}
    }
    
    public Tile[][] getMeadow(){
    	return meadow;
    }
}
