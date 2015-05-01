package model;

public class Battle {
	Pokemon pokemon = null;
	Character character = null;
	int[] result = new int[4]; //stores run rate, catch rate, turns and result
	/*
	 * constructor
	 */
	public Battle(Pokemon p, Character c){
		pokemon = p;
		character = c;
		result[0] = pokemon.getRunChance();
		result[1] = pokemon.getCatchRate();
		result[2] = pokemon.getMaxTurns();
	}

	
}
