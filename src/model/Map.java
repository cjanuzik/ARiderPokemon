package model;



import java.util.Observable;

import model.Tiles.FenceBottom;
import model.Tiles.FenceBottomLeft;
import model.Tiles.FenceBottomRight;
import model.Tiles.FenceLeft;
import model.Tiles.FenceRight;
import model.Tiles.FenceTopLeft;
import model.Tiles.FenceTopRight;
import model.Tiles.MeadowGrass;
import model.Tiles.TallGrass;
import model.Tiles.TreeBottomLeft;
import model.Tiles.TreeBottomRight;
import model.Tiles.TreeLeft;
import model.Tiles.TreeRight;
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
import view.GraphicPanel;

public class Map extends Observable{
	private Tile[][] map; // tiles of the map
	public final static int height = 31; 
	public final static int width = 32;
	
	// the row and column of the current location of the Trainer
	private int c;
	private int r;
	private boolean hasMoved;



	/**
	 * Constructs a new instance of map
	 */
	public Map() {
		makeMap();
		
		// place the hunter randomly
		this.c = 15;
		this.r = 0;
		
		this.map[r][c].setHasCharacter(true);
	}
	
	/**
	 * instantiates each tile/
	 */
	private void makeMap() {
		map = new Tile[][] {
				{new FenceTopLeft(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceTopRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceTopLeft(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceTopRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottomRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceBottomLeft(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new WaterTopLeft(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTopRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new WaterLeft(), new Water(), new Water(), new Water(), new WaterRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TreeTopLeft(), new TreeTopRight(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(),new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new WaterLeft(), new Water(), new Water(), new Water(), new WaterRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TreeLeft(), new TreeRight(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(),new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new WaterBottomLeft(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottomRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TreeBottomLeft(), new TreeBottomRight(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TreeTopLeft(), new TreeTopRight(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TreeLeft(), new TreeRight(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceBottomLeft(), new FenceBottom(), new FenceBottom(), new FenceBottomRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TreeBottomLeft(), new TreeBottomRight(), new TallGrass(), new TallGrass(), new FenceBottomLeft(), new FenceBottom(), new FenceBottom(), new FenceBottomRight()},
		        {new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new WaterTopLeft(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTopRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass()},
		        {new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new WaterLeft(), new Water(), new Water(), new Water(), new Water(), new Water(), new WaterRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass()},
		        {new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new WaterBottomLeft(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottomRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass()},
		        {new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass()},
		        {new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new WaterTopLeft(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTop(), new WaterTopRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass()},
		        {new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new WaterLeft(), new Water(), new Water(), new Water(), new Water(), new Water(), new Water(), new Water(), new WaterRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass()},
		        {new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new WaterBottomLeft(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottom(), new WaterBottomRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass()},
		        {new FenceTopLeft(), new FenceBottom(), new FenceBottom(), new FenceTopRight(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceTopLeft(), new FenceBottom(), new FenceBottom(), new FenceTopRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new TallGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottomRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceBottomLeft(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceLeft(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceRight()},
				{new FenceTopLeft(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceTopRight(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new MeadowGrass(), new FenceTopLeft(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceBottom(), new FenceTopRight()},

		};
		//Meadow meadow = new Meadow();
		//map = meadow.getMeadow();
		
	}
	/**
	 * Moves the hunter in the direction specified with wrap around 
	 * @param d The direction of movement
	 */
	public void move(Dir d, GraphicPanel g) {
		hasMoved = false;
		switch (d) {
		case DOWN:
			moveDown();
			g.loadImages("Down");
			break;
		case LEFT:
			moveLeft();
			g.loadImages("Left");
			break;
		case RIGHT:
			moveRight();
			g.loadImages("Right");
			break;
		case UP:
			moveUp();
			g.loadImages("Up");
			break;
		default:
			break;

		}
		
		Tile nextTile = tileAt(r,c);
		boolean canEncounter = nextTile.getCanEncounter();
		
		if(canEncounter == true && hasMoved){
		    int encountered = (int) (Math.random() * 10);
		
		    if(encountered == 1){
			    System.out.println("You have encountered a wild Pokemon!");
		    }
		}
		
		setChanged();
		notifyObservers();
	}
	/**
	 * moves character up
	 */
	private void moveUp() {
		if(!tileAt(r - 1, c).getSolid()){
    		map[r][c].setHasCharacter(false);
	    	r--;
		    map[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}
	/**
	 * moves character down
	 */
	private void moveDown() {
		if(!tileAt(r + 1, c).getSolid()){
		    map[r][c].setHasCharacter(false);
		    r++;
		    map[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}
	/**
	 * moves character right
	 */
	private void moveRight() {
		if(!tileAt(r,c + 1).getSolid()){
		    map[r][c].setHasCharacter(false);
		    c++;
		    map[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}
	/**
	 * moves character left
	 */
	private void moveLeft() {
		if(!tileAt(r,c - 1).getSolid()){
		    map[r][c].setHasCharacter(false);
		    c--;
		    map[r][c].setHasCharacter(true);
		    hasMoved = true;
		}
	}

	/**
	 * returns the tile at the coordinates passed
	 * @param x
	 * @param y
	 * @return Tile
	 */
	public Tile tileAt(int x, int y) {
		return map[x][y];

	}
	
	public int getC(){
		return c;
	}
	
	public int getR(){
		return r;
	}
	/**
	 * returns a String representation of the hunter 
	 * 
	 * @see Object#toString()
	 */
	public String toString() {
		return "The Width of the map is :"+width +"\nThe height of the map is: "+height +"\nThe hunter is at:\n" + "Row: " + r + "\nCol: " + c + "\n";
	}

	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
}
