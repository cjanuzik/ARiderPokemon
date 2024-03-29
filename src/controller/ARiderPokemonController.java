package controller;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.GraphicPanel;
import view.BattlePanel;
import view.HomePanel;
import view.SummaryPanel;
import model.Inventory;
import model.Map;

/**
 * This class is the main controller class for the program and executes all the code
 * 
 * @author Chris, Aakash, Sean, Yash
 *
 */
public class ARiderPokemonController extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//Components needed for JScrollPane
	
	/**
	 * master panel for the controller. Display the main game panel
	 */
	private static JPanel master;
	/**
	 * Battle Panel
	 */
	private static BattlePanel battlePanel;
	/**
	 * panel for the map. It displays the map
	 */
	private static GraphicPanel mapPanel;
	/**
	 * displays the home screen of the game
	 */
	private HomePanel homePanel;
	/**
	 * Displays the summary of the battle.
	 */
	private static SummaryPanel summaryPanel;
	private static JScrollPane graphic; // graphic view
	
	//Panels needed for building the border then add to mainPanel
	private JLabel GBCTop, GBCLeft, GBCRight, GBCBottom;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JPanel mainPanel;
	
	//Current instance of a Map
	/**
	 * map instance to create the map in the controller
	 */
	private static Map map;
	
	//Creates new instance of map and layouts the GUI
	/**
	 * constructor: calls loadImage() and layoutGUI(). and initializes the variables
	 */

	public ARiderPokemonController() {
		
		map = new Map();
		loadImages();
		layoutGUI();
	}
    
	//Initializes image variables
	/**
	 * loads all the images for the JLabels (GBC)
	 * @throws IOException
	 * 
	 */
	public void loadImages(){
		try {
		    BufferedImage GBCComponent = ImageIO.read(new File("Images/GBC/GBCTop.png"));
		    GBCTop = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCLeft.png"));
		    GBCLeft = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCRight.png"));
		    GBCRight = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCBottom.png"));
		    GBCBottom = new JLabel(new ImageIcon(GBCComponent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Layouts the GUI
	/**
	 * sets the basic layout. Calls makeAndLayoutViews(), buildMenuBar() and setLayoutAndAddComponentsToFrame();
	 * 
	 */
	public void layoutGUI() {
		makeAndLayoutViews();
		buildMenuBar();
		setLayoutAndAddComponentsToFrame();
	}
    
	//Makes all the components of the GUI
	/**
	 * initializes all the swing components like JPanels JButtons etc.
	 * Adds functionality to them.
	 * Sets the layout of panels
	 */
	private void makeAndLayoutViews() {
		master = new JPanel();
		mapPanel = new GraphicPanel(map);
		battlePanel = new BattlePanel(map);
		homePanel = new HomePanel();
		summaryPanel = new SummaryPanel();
		master.add(mapPanel);
		master.add(battlePanel);
		master.add(homePanel);
		master.add(summaryPanel);
		graphic = new JScrollPane(master);
		graphic.setViewportView(homePanel);
		graphic.setPreferredSize(new Dimension(352, 352));
		graphic.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        graphic.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		topPanel = new JPanel(new BorderLayout());
		centerPanel = new JPanel(new BorderLayout());
		bottomPanel = new JPanel(new BorderLayout());
		mainPanel = new JPanel(new BorderLayout());
        topPanel.add(GBCTop, BorderLayout.SOUTH);
        centerPanel.add(GBCLeft, BorderLayout.WEST);
	    centerPanel.add(graphic, BorderLayout.CENTER);
		centerPanel.add(GBCRight, BorderLayout.EAST);
		bottomPanel.add(GBCBottom, BorderLayout.NORTH);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	}
	
	//Builds a menu bar and adds it to the Frame
	/**
	 * builds the menu bar by initializing all the components, adding JMenu Items to it.
	 * 
	 */
    private void buildMenuBar(){
    	//Add JMenuBar to Frame
		JMenuBar theMenuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File"); 
		JMenu inventoryMenu = new JMenu("Inventory");
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new AboutActionListener());
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ExitActionListener());
		JMenuItem controlsItem = new JMenuItem("Controls");
		controlsItem.addActionListener(new ControlsActionListener());
		JMenuItem hmItem = new JMenuItem("HM");
		hmItem.addActionListener(new hmActionListener());
		JMenuItem pokemonItem = new JMenuItem("Pokemon");
		pokemonItem.addActionListener(new pokemonActionListener());
		JMenuItem infoItem = new JMenuItem("Info");
		infoItem.addActionListener(new infoActionListener());
		
		fileMenu.add(aboutItem);
		fileMenu.add(controlsItem);
		fileMenu.add(exitItem);
		inventoryMenu.add(hmItem);
		inventoryMenu.add(pokemonItem);
		inventoryMenu.add(infoItem);
		theMenuBar.add(fileMenu);
		theMenuBar.add(inventoryMenu);
		this.setJMenuBar(theMenuBar);
    }
    
    //Adds all main components to the frame
    /**
     * this function builds the JFrame by adding the required things
     */
	private void setLayoutAndAddComponentsToFrame() {
		setTitle("Pokemon - Safari Zone");
		this.setLayout(new BorderLayout());
		this.add(mainPanel, BorderLayout.NORTH);
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
    
	//Swaps to battle panel when a battle is triggered
	/**
	 * switches the battle panel when a battle is triggered
	 */
	public static void addBattlePanel(){
		battlePanel = new BattlePanel(map);
		graphic.setViewportView(battlePanel);
	}
	
	//Swaps to map panel when a battle is over / homePanel is done
	/**
	 * Swaps to map panel when a battle is over / homePanel is done
	 */
	public static void addMapPanel(){
		graphic.setViewportView(mapPanel);
		mapPanel.comeBack();
	}
	/**
	 * swaps to summary panel when the battle is over
	 */
	public static void addSummaryPanel(){
		summaryPanel = new SummaryPanel();
		graphic.setViewportView(summaryPanel);
	}
	
    //Listener for about file item to give the player info about the project
	/**
	 * Listener for about file item to give the player info about the project
	 *
	 *
	 */
	private class AboutActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
            JPanel panel = new JPanel(new BorderLayout());
			
			JLabel first = new JLabel("This is a Pokemon Safari Zone game");
			JLabel second = new JLabel("made for our CSc 335 final project!");
			
			panel.add(first, BorderLayout.NORTH);
			panel.add(second, BorderLayout.CENTER);
			JOptionPane.showMessageDialog(null, panel);

		}
	}
	/**
	 * Listener for exit file item to exit the projects
	 *
	 *
	 */
	private class ExitActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?", "Exit?",  JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION)
			{
			   System.exit(0);
			}
			// TODO Auto-generated 
		}
		
	}
	
	//Listener for Controls file item to show player the controls
	/**
	 * Listener for Controls file item to show player the controls
	 *
	 *
	 */
	private class ControlsActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new BorderLayout());
			
			JLabel move = new JLabel("Arrow Keys: move");
			JLabel interact = new JLabel("Return/Enter: interact");
			
			panel.add(move, BorderLayout.NORTH);
			panel.add(interact, BorderLayout.CENTER);
			JOptionPane.showMessageDialog(null, panel);
		}
	}
	
	//Listner for HM file item, shows the player what HM they have unlocked
	/**
	 * Listner for HM file item, shows the player what HM they have unlocked
	 * 
	 * 
	 *
	 */
	private class hmActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new BorderLayout());
		
			JLabel surf = new JLabel("You do not have HM Surf");
			JLabel rockSmash = new JLabel("You do not have HM Rock Smash");
			
			if(Inventory.getSurfUnlocked())
				surf = new JLabel("You have unlocked HM Surf!");
			if(Inventory.getRockSmashUnlocked())
				rockSmash = new JLabel("You have unlocked HM Rock Smash!");
			
			panel.add(surf, BorderLayout.NORTH);
			panel.add(rockSmash, BorderLayout.CENTER);
			
			JOptionPane.showMessageDialog(null, panel);
		}
	}
	
	//Listener for info file item, shows the player's steps and ball count
/**
 * Listener for info file item, shows the player's steps and ball count
 * 
 *
 */
	private class infoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new BorderLayout());
			
			JLabel balls = new JLabel("Safari balls remaining: " + Inventory.getBalls());
			JLabel steps = new JLabel("Number of steps remaining: " + Inventory.getSteps());
			
			panel.add(balls, BorderLayout.NORTH);
			panel.add(steps, BorderLayout.CENTER);
			JOptionPane.showMessageDialog(null, panel);
		}
	}
	
	/**
	 * Listener for infor pokemon item, shows what Pokemon the player has caught
	 * 
	 *
	 */
	private class pokemonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new GridLayout(Inventory.listPokemon().size() - 1, 1));
			
			for(int i = 0; i < Inventory.listPokemon().size(); i++){
				panel.add(new JLabel("" + Inventory.listPokemon().get(i).getName()));
			}
			
			JOptionPane.showMessageDialog(null, panel);
		}
	}
	//Calls GameView to start the game
	/**
	 * Calls GameView to start the game
	 * @param args
	 */
	public static void main(String[] args) {
		new ARiderPokemonController();
	}
	
}
