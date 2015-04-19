package model;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;


public class Pokedex {
    private static Map<Pokemon,Integer> pokemonTable = new HashMap<Pokemon,Integer>(10);
    private Long seenBitmap;
    private Long caughtBitmap;
    
    public Pokedex(){
=======

import java.util.HashMap;
import java.util.Map;

public class Pokedex {
	private static Map<String,Integer> pokemonTable = new HashMap<String,Integer>(10);
	private Long seenBitmap;
	private Long caughtBitmap;
	
	public Pokedex(){
>>>>>>> 96da19d11e6a8134a671bfa44cc9f9d375509bf3
    	
    }
}
