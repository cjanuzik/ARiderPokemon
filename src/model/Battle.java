package model;

public class Battle {
	Pokemon pokemon = null;
	Character character = null;
	int[] result = new int[4]; //stores runRate CatchRate turns result
	
	/*
	 * constructor
	 */
	public Battle(Pokemon p){
		pokemon = p;
		result[0] = pokemon.getRunChance();
		result[1] = pokemon.getCatchRate();
		result[2] = pokemon.getMaxTurns();
	}
	/*
	 * throwbait
	 */
	public int[] throwBait(){
		result[0] -= result[0]/2;
		result[1] -= result[1]/2;
		result[2]--;
		result[3] = result(result[1], result[0]);
		
		return result;
		
	}
	/*
	 * When Rock is thrown
	 */
	public int[] throwRock(){
		result[0] += result[0]/2;
		result[1] += result[1]/2;
		result[2]--;
		result[3] = result(result[1], result[0]);
		
		return result;
		
	}
	/*
	 * When a Pokeball is thrown,
	 * the Pokemon is caught on the basis of probability
	 * the rarer the pokemon, the lesser the probability of it being caught 
	 */
	 public int[] throwPokeball(){
		 int max = 0,min = 0,prob = 0;
		 if(pokemon.getRarity() == 0){   //common pokemon
			 max = 11;
			 min = 1;
			 
			 prob = min + (int)(Math.random() * ((max - min) + 1));
			 
			 if(prob == 7){
				 result[3]=1;
			 }
			 else
				 result[3]=-1;
		 }
		 if(pokemon.getRarity() == 1){  //uncommon pokemon
			 max = 21;
			 min = 1;
			 
			 prob = min + (int)(Math.random() * ((max - min) + 1));
			 
			 if(prob == 7){
				 result[3]=1;
			 }
			 else
				 result[3]=-1;
		 }
		 if(pokemon.getRarity() == 2){  //unique pokemon
			 max = 101;
			 min = 1;
			 
			 prob = min + (int)(Math.random() * ((max - min) + 1));
			 
			 if(prob == 7){
				 result[3]=1;
			 }
			 else
				 result[3]=-1;
		 }
		 
		 return result;
	 }
	/*
	 * returns the result of the fight
	 * -1 = Pokemon ran away
	 * 0 = continue the battle
	 * 1 = Pokemon is caught
	 */
	public int result(int catchRate, int runChance){
		if(runChance > 100 || result[2] == 0){
			return -1;    //pokemon ran away
		}
		
		else if(catchRate >= 90){
			return 1;    //pokemon caught
		}
		else 
		return 0;
	}
	
	
}
