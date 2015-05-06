package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ARiderPokemonController;
/**
 * designs th home panel of the controller. This asks to select the play style and displays the rules
 * @author Aakash
 *
 */
public class HomePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	final public static int MEWTWO_WIN = 1;
	final public static int TEN_WIN = 2;
	final public static int NO_WIN = 3;
	private static int winChosen;
	
	JPanel rulesPanel, choicePanel;
	JButton mewtwoWin, tenWin, noWin;
	JLabel choose, rules0, rules1, rules2, lucky, normal, roam;
	/**
	 * calls LayoutGUI() and makeAndLayoutViews() also initializes the winChosen(winCondition chosen by the player) variable with zero
	 */
	public HomePanel(){
		winChosen = 0;
		layoutGUI();
		registerListeners();
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
	private void makeAndLayoutViews(){
		mewtwoWin = new JButton("Lucky");
		tenWin = new JButton("Normal");
		noWin = new JButton("Roam");
		mewtwoWin.setPreferredSize(new Dimension(60, 50));
		tenWin.setPreferredSize(new Dimension(60, 50));
		noWin.setPreferredSize(new Dimension(60, 50));
		
		choose = new JLabel("Choose one of the following play styles:");
		rules0 = new JLabel("Rules:");
		rules1 = new JLabel("1) You have 500 steps.");
		rules2 = new JLabel("2) You have 30 Safari balls.");
		lucky = new JLabel("Catch the legendary Mewtwo!                ");
		normal = new JLabel("Catch a total of 10 Pokemon!                ");
		roam = new JLabel ("See how many Pokemon you can catch!");
		
		rulesPanel = new JPanel(new GridLayout(4, 1));
		rulesPanel.add(rules0);
		rulesPanel.add(rules1);
		rulesPanel.add(rules2);
		rulesPanel.add(choose);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		choicePanel = new JPanel(new GridLayout(3,1));
		panel1.add(mewtwoWin);
		panel1.add(lucky);
		panel2.add(tenWin);
		panel2.add(normal);
		panel3.add(noWin);
		panel3.add(roam);
		choicePanel.add(panel1);
		choicePanel.add(panel2);
		choicePanel.add(panel3);
	}
	/**
	 * Adds main components to the HomePanel.
	 * initializes the things needed for building the panel Layout
	 */
	private void setLayoutAndAddComponentsToPanel() {
		this.setPreferredSize(new Dimension(352, 352));
		this.setVisible(true);
		this.setLayout(new GridLayout(2,1));
		this.add(rulesPanel);
		this.add(choicePanel);
		
	}
	
	/**
	 * registers the listeners. Calls the required classes and functions to add actionListeners to the components
	 */
	private void registerListeners(){
		ChoiceListener listen = new ChoiceListener();
		mewtwoWin.addActionListener(listen);
		tenWin.addActionListener(listen);
		noWin.addActionListener(listen);
	}
    /**
     * returns the win condition
     * @return winChosen
     */
	public static int getWinCondition(){
		return winChosen;
	}
	/**
	 * action Listener class to add action to the win condition chosen by the player
	 * @author Aakash
	 *
	 */
	private class ChoiceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mewtwoWin)
				winChosen = MEWTWO_WIN;
			
			if(e.getSource() == tenWin)
				winChosen = TEN_WIN;
			
			if(e.getSource() == noWin)
				winChosen = NO_WIN;
			
			ARiderPokemonController.addMapPanel();
		}
		
	}
}
