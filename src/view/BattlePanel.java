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
import javax.swing.JScrollPane;
import javax.swing.Timer;

import model.Battle;
import model.Inventory;
import model.Map;
import model.NotEnoughBallsException;
import controller.ARiderPokemonController;

/**
 * Designs the battle panel of the code
 * 
 */
public class BattlePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	// Current instance of a battle
	/**
	 * Current instance of a battle
	 */
	private Battle battle;
	private Timer timer = null;
	private Timer runPause = null;
	private boolean caught;
	private boolean ran;
	private boolean isWaiting;
	//GUI components of BattlePanel
	private JScrollPane graphic, textGraphic;
	private JPanel buttonPanel, trainerPanel, master, textFeed, pokemonPanel, ranPanel;
    private JButton throwBait, throwRock, run, throwBall;
	private JLabel trainerPic, pokemonPic, ballPic, pokemonBar, ballFeed, encounterFeed, brokeFeed, baitFeed, rockFeed, runFeed;
	
	//Initializes a new battle and calls layoutGUI
	/**
	 * Initializes a new battle and calls layoutGUI
	 * @param map
	 */
	public BattlePanel(Map map) {
		battle = new Battle(map);
		ran = false;
		caught = false;
		isWaiting = false;
		layoutGUI();
		registerListeners();
	}
    
	//Layouts the GUI
	/**
	 * Layouts the GUI
	 */
	private void layoutGUI(){
		makeAndLayoutViews();
		setLayoutAndAddComponentsToFrame();
	}
	
	//Adds main components to the BattlePanel
	/**
	 * Adds main components to the BattlePanel
	 */
	private void setLayoutAndAddComponentsToFrame() {
		this.setPreferredSize(new Dimension(352, 352));
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.add(pokemonPanel, BorderLayout.NORTH);
		this.add(trainerPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
    
	//Creates components and adds them to each other
	/**
	 * Creates components and adds them to each other
	 * @throws IOException
	 */
	private void makeAndLayoutViews() {
		
		//Create main panels and buttons
		pokemonPanel = new JPanel(new GridLayout(1,2));
		trainerPanel = new JPanel(new GridLayout(1,2));
		ranPanel = new JPanel();
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
		master.add(ranPanel);
		
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
		runFeed = new JLabel(battle.getPokemon().getName() + " has fled!");
		textFeed.add(encounterFeed);
		textFeed.add(ballFeed);
		textFeed.add(brokeFeed);
		textFeed.add(baitFeed);
		textFeed.add(rockFeed);
		textFeed.add(runFeed);
		
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
	/**
	 * Registers listeners to buttons
	 * @throws NotEnoughBallsException
	 */
	private void registerListeners() {
		
		//Timer to wait when displaying if the pokemon fled
		runPause = new Timer(3000, new ActionListener(){      // Timer 3 seconds
		    public void actionPerformed(ActionEvent e) {
	          	runPause.stop();
		            	
	        	ARiderPokemonController.addMapPanel();
		            	
	            repaint(); //updates
		    }
		});
				
		//Timer to swap out JPanels when trying to catch and calcuates if caught
		timer = new Timer(3000, new ActionListener(){      // Timer 3 seconds
            public void actionPerformed(ActionEvent e) {
            	timer.stop();
            	isWaiting = false;
            	
            	if(caught){
        			Inventory.addPokemon(battle.getPokemon());
        			ARiderPokemonController.addMapPanel();
        		}
            	
            	graphic.setViewportView(pokemonPic); //Changes view to Pokemon after 3 sec.
            	textGraphic.setViewportView(brokeFeed);
            	repaint(); //updates
            	
            	if(ran){
					textGraphic.setViewportView(runFeed);
					graphic.setViewportView(ranPanel);
					repaint();
					runPause.start();
				}
            	
            }
        });
		
		//Throws ball, swaps JPanels, calls timer
		throwBall.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	if(!isWaiting){
            		isWaiting = true;
            		
            		ran = battle.didRun();
            		
            	    caught = battle.isCaught();
            	    try{
            	        Inventory.updateBallCount(-1);
            	        textGraphic.setViewportView(ballFeed);
            	        graphic.setViewportView(ballPic);
                        repaint();                  // updates
                        timer.start();              // starts the timer
            	    } catch(NotEnoughBallsException nebe){
            	    	ARiderPokemonController.addSummaryPanel();
            	    }
            	}
            }
        });
		
		//Creates listeners for throwBait, throwRock and run buttons
		BattleListener listen = new BattleListener();
		throwBait.addActionListener(listen);
		throwRock.addActionListener(listen);
		run.addActionListener(listen);
		
		ActionListener runListen = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				if(battle.didRun() || battle.checkTurns()){
					ran = true;
					textGraphic.setViewportView(runFeed);
					graphic.setViewportView(ranPanel);
					repaint();
					runPause.start();
				}
					
			}
		};
		throwBait.addActionListener(runListen);
		throwRock.addActionListener(runListen);

	}
	
	
	
	//Checks which button was pressed then performs the correct actions.
	/**
	 * Checks which button was pressed then performs the correct actions.
	 * @author Aakash
	 *
	 */
	private class BattleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == throwBait && !ran){
				textGraphic.setViewportView(baitFeed);
				battle.getPokemon().adjustRunChance(-1);
				battle.getPokemon().adjustCatchRate(-1);
			}
			if(e.getSource() == throwRock && !ran){
				textGraphic.setViewportView(rockFeed);
				battle.getPokemon().adjustRunChance(1);
				battle.getPokemon().adjustCatchRate(1);
			}
			if (e.getSource() == run && !ran)
				ARiderPokemonController.addMapPanel();
		}
	}

}
