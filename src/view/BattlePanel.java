package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.Battle;
import model.Inventory;
import model.Map;
import controller.GameView;

public class BattlePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	// Current instance of a battle
	private Battle battle;
	private Timer timer = null;
	private boolean caught;
	//GUI components of BattlePanel
	private JScrollPane graphic, textGraphic;
	private JPanel buttonPanel, trainerPanel, master, textFeed, pokemonPanel;
    private JButton throwBait, throwRock, run, throwBall;
	private JLabel trainerPic, pokemonPic, ballPic, pokemonBar, ballFeed, encounterFeed, brokeFeed, baitFeed, rockFeed;
	
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
		
		//Create main panels and buttons
		pokemonPanel = new JPanel(new GridLayout(1,2));
		trainerPanel = new JPanel(new GridLayout(1,2));
		buttonPanel = new JPanel(new GridLayout(2,2));
		throwBait = new JButton("Throw Bait");
		throwRock = new JButton("Throw Rock");
		throwBall = new JButton("Throw Ball");
		run = new JButton("Run");
		
		//Load Pictures
		try{
		    BufferedImage image = ImageIO.read(new File("Images/Battle/BattleTrainer.png"));
	        trainerPic = new JLabel(new ImageIcon(image));
	        image = ImageIO.read(new File("Images/Battle/" + battle.getPokemon().getName() + ".png"));
	        pokemonPic = new JLabel(new ImageIcon(image));
	        image = ImageIO.read(new File("Images/Battle/" + battle.getPokemon().getType() + "BallActive.png"));
	        ballPic = new JLabel(new ImageIcon(image));
	        image = ImageIO.read(new File("Images/Battle/" + battle.getPokemon().getName() + "Bar.png"));
	        pokemonBar = new JLabel(new ImageIcon(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Add ballPic and pokemonPic to master panel
		master = new JPanel();
		master.add(pokemonPic);
		master.add(ballPic);
		
		//Add pokemon slides to graphic and set view panel
		graphic = new JScrollPane(master);
		graphic.setViewportView(pokemonPic);
		graphic.setPreferredSize(new Dimension(132, 132));
		graphic.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        graphic.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//Create main panel components
		pokemonPanel.add(pokemonBar, BorderLayout.WEST);
		pokemonPanel.add(graphic, BorderLayout.CENTER);
		
		//Create TextFeed panel and add different labels with text
		textFeed = new JPanel();
		encounterFeed = new JLabel("A wild " + battle.getPokemon().getName() + " appeared!");
		ballFeed = new JLabel("You throw a safari ball...");
		brokeFeed = new JLabel(battle.getPokemon().getName() + " broke free!");
		baitFeed = new JLabel("You throw some bait...");
		rockFeed = new JLabel("You throw a rock...");
		textFeed.add(encounterFeed);
		textFeed.add(ballFeed);
		textFeed.add(brokeFeed);
		textFeed.add(baitFeed);
		textFeed.add(rockFeed);
		
		//Add textFeed to textGraphic and default to encountered Pokemon
		textGraphic = new JScrollPane(textFeed);
		textGraphic.setViewportView(encounterFeed);
		textGraphic.setPreferredSize(new Dimension(200, 200));
		textGraphic.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        textGraphic.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		trainerPanel.add(trainerPic, BorderLayout.WEST);
		trainerPanel.add(textGraphic, BorderLayout.CENTER);
		buttonPanel.add(throwBall);
		buttonPanel.add(throwBait);
		buttonPanel.add(throwRock);
		buttonPanel.add(run);
	}
	
	//Registers listeners to buttons
	private void registerListeners() {
		
		//Timer to swap out JPanels when trying to catch and calcuates if caught
		timer = new Timer(3000, new ActionListener(){      // Timer 3 seconds
            public void actionPerformed(ActionEvent e) {
            	timer.stop();
            	if(caught){
        			Inventory.addPokemon(battle.getPokemon());
        			GameView.addMapPanel();
        		}
            	graphic.setViewportView(pokemonPic); //Changes view to Pokemon after 3 sec.
            	textGraphic.setViewportView(brokeFeed);
            	
            	if(battle.checkTurns())
            		GameView.addMapPanel();
            	
                repaint(); //updates
            }
        });
		
		//Throws ball, swaps JPanels, calls timer
		throwBall.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	caught = false;
            	caught = battle.isCaught();
            	Inventory.updateBallCount(-1);
            	textGraphic.setViewportView(ballFeed);
            	graphic.setViewportView(ballPic);
                repaint();                  // updates
                timer.start();              // starts the timer
            }
        });
		
		//Creates listeners for throwBait, throwRock and run buttons
		BattleListener listen = new BattleListener();
		throwBait.addActionListener(listen);
		throwRock.addActionListener(listen);
		
		run.addActionListener(listen);

	}
	
	//Checks which button was pressed then performs the correct actions.
	private class BattleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == throwBait){
				textGraphic.setViewportView(baitFeed);
			}
			if(e.getSource() == throwRock){
				textGraphic.setViewportView(rockFeed);
			}
			if (e.getSource() == run)
				GameView.addMapPanel();
		}
	}

}
