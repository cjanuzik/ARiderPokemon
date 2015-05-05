package view;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Battle;
import model.Inventory;
import model.Map;
import controller.GameView;

public class BattlePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	// Current instance of a battle
	private Battle battle;
	
	//GUI components of BattlePanel
	private JPanel pokemonPanel, buttonPanel, trainerPanel;
    private JButton throwBait, throwRock, run, throwBall;
	private JLabel trainerPic, pokemonPic, pokemonBar, actionFeed;
	
	//Initializes a new battle and calls layoutGUI
	public BattlePanel(Map map) {
		battle = new Battle(map);
		layoutGUI();
		registerListeners();
	}
    
	//Layouts the GUI
	private void layoutGUI(){
		makeAndLayoutViews();
		setLayoutAndAddComponentsToFrame();
	}
	
	//Adds main components to the BattlePanel
	private void setLayoutAndAddComponentsToFrame() {
		this.setPreferredSize(new Dimension(352, 352));
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(pokemonPanel, BorderLayout.NORTH);
		this.add(trainerPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
    
	//Creates components and adds them to eachother
	private void makeAndLayoutViews() {
		pokemonPanel = new JPanel(new GridLayout(1,2));
		trainerPanel = new JPanel(new GridLayout(1,2));
		buttonPanel = new JPanel(new GridLayout(2,2));
		throwBait = new JButton("Throw Bait");
		throwRock = new JButton("Throw Rock");
		throwBall = new JButton("Throw Ball");
		run = new JButton("Run");
		try{
		    BufferedImage image = ImageIO.read(new File("Images/Battle/BattleTrainer.png"));
	        trainerPic = new JLabel(new ImageIcon(image));
	        image = ImageIO.read(new File("Images/Battle/" + battle.getPokemon().getName() + ".png"));
	        pokemonPic = new JLabel(new ImageIcon(image));
	        image = ImageIO.read(new File("Images/Battle/" + battle.getPokemon().getName() + "Bar.png"));
	        pokemonBar = new JLabel(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		actionFeed = new JLabel("A wild " + battle.getPokemon().getName() + " appeared!");
		pokemonPanel.add(pokemonBar);
		pokemonPanel.add(pokemonPic);
		trainerPanel.add(trainerPic);
		trainerPanel.add(actionFeed);
		buttonPanel.add(throwBall);
		buttonPanel.add(throwBait);
		buttonPanel.add(throwRock);
		buttonPanel.add(run);
	}
    
	//Registers listeners to buttons
	private void registerListeners() {

		// TODO 9: uncomment the code below and talk about
		BattleListener listen = new BattleListener();
		throwBait.addActionListener(listen);
		throwRock.addActionListener(listen);
		throwBall.addActionListener(listen);
		run.addActionListener(listen);

	}
	
	//Checks which button was pressed then performs the correct actions.
	private class BattleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == throwBall){
				actionFeed.setText("You throw a safari ball!");
				Inventory.updateBallCount(-1);
				try{
					pokemonPanel.remove(pokemonPic);
					String type = battle.getPokemon().getType();
					BufferedImage image = ImageIO.read(new File("Images/Battle/" + type + "BallActive.png"));
		            pokemonPic = new JLabel(new ImageIcon(image));
		            pokemonPanel.add(pokemonPic, BorderLayout.EAST);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			if(e.getSource() == throwBait){
				actionFeed.setText("You throw some bait!");
			}
			if(e.getSource() == throwRock){
				actionFeed.setText("You throw a rock!");
			}
			if (e.getSource() == run)
				GameView.addMapPanel();
		}
	}

}
