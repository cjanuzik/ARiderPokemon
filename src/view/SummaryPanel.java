package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Inventory;
import model.Mewtwo;

/**
 * panel to display the summary of the battle.
 *
 */
public class SummaryPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	int winCondition;
	JLabel surf, rockSmash, won;
	JPanel caught;
	
	/**
	 * initializes the win condition with information from the HomePanel class
	 * calls layoutGUI() to set the layout of the GUI
	 */
	public SummaryPanel(){
        winCondition = HomePanel.getWinCondition();
        layoutGUI();
	}
	/**
	 * sets the layout of the GUI for this panel
	 */
	private void layoutGUI(){
		makeAndLayoutViews();
		setLayoutAndAddComponentsToPanel();
	}

	/**
	 * adds functionality to the panel. 
	 * initializes all the swing components like JPanel, JButton etc
	 */
	
	private void makeAndLayoutViews() {
		checkWon();
		caught = new JPanel(new GridLayout(Inventory.listPokemon().size() - 1, 1));
		
		for(int i = 0; i < Inventory.listPokemon().size(); i++){
			caught.add(new JLabel("" + Inventory.listPokemon().get(i).getName()));
		}
		
		surf = new JLabel("You did not find the HM surf...");
		rockSmash = new JLabel("You did not find the HM rock smash...");
		
		if(Inventory.getSurfUnlocked())
		    surf = new JLabel("You found the HM surf!");
		
		if(Inventory.getRockSmashUnlocked())
			rockSmash = new JLabel("You found the HM rock smash!");
		
		
		
	}
	/**
	 * Adds main components to the HomePanel.
	 * initializes the things needed for building the panel Layout
	 */
	private void setLayoutAndAddComponentsToPanel() {
		// TODO Auto-generated method stub
		this.setPreferredSize(new Dimension(352, 352));
		this.setVisible(true);
		this.setLayout(new GridLayout(4,1));
		this.add(won);
		this.add(caught);
		this.add(surf);
		this.add(rockSmash);
	}
	
	//Sets the won JLabel depending on conditions.
	/**
	 * Sets the won JLabel depending on conditions.
	 */
	private void checkWon(){
		//Defaults to a loss
		won = new JLabel("Better luck next time!");
		
		//Checks if catching Mewtwo wins and checks if caught
		if(winCondition == HomePanel.MEWTWO_WIN){
			if(Inventory.hasMewtwo()){
				won = new JLabel("Congratulations! You caught Mewtwo!");
			}
		}
		
		//Checks if ten to win wins and checks how many Pokemon caught
		if(winCondition == HomePanel.TEN_WIN){
			if(Inventory.listPokemon().size() >= 10){
				won = new JLabel("Congratulations! You caught " + Inventory.listPokemon().size() + " Pokemon!");
			}
		}
		
		//Checks if roam was chosen and prints amount of caught pokemon
		if(winCondition == HomePanel.NO_WIN){
			int numCaught = Inventory.listPokemon().size();
			if(numCaught == 0){
				won = new JLabel("You didn't catch any Pokemon...");
			}
			if(numCaught <= 5){
				won = new JLabel("You only caught " + numCaught + " Pokemon...");
			}
			if(numCaught <= 10){
				won = new JLabel("You caught " + numCaught + " Pokemon.");
			}
			if(numCaught > 10){
				won = new JLabel("Congratulations! You caught " + numCaught + " Pokemon!");
			}
		}
		
	}
}
