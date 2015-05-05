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
import model.Inventory;
import model.Map;

public class GameView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//Components needed for JScrollPane
	private static JPanel master;
	private static BattlePanel battlePanel;
	private static GraphicPanel mapPanel;
	private HomePanel homePanel;
	private static JScrollPane graphic; // graphic view
	
	//Panels needed for building the border then add to mainPanel
	private JLabel GBCTop, GBCLeft, GBCRight, GBCBottom;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JPanel mainPanel;
	
	//Current instance of a Map
	private static Map map;
	
	//Creates new instance of map and layouts the GUI
	public GameView() {
		
		map = new Map();
		loadImages();
		layoutGUI();
	}
    
	//Initializes image variables
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
	public void layoutGUI() {
		makeAndLayoutViews();
		buildMenuBar();
		setLayoutAndAddComponentsToFrame();
	}
    
	//Makes all the components of the GUI
	private void makeAndLayoutViews() {
		master = new JPanel();
		mapPanel = new GraphicPanel(map);
		battlePanel = new BattlePanel(map);
		homePanel = new HomePanel();
		master.add(mapPanel);
		master.add(battlePanel);
		master.add(homePanel);
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
    private void buildMenuBar(){
    	//Add JMenuBar to Frame
		JMenuBar theMenuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File"); 
		JMenu inventoryMenu = new JMenu("Inventory");
		JMenu pokedexMenu = new JMenu("Pokedex");
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new AboutActionListener());
		JMenuItem controlsItem = new JMenuItem("Controls");
		controlsItem.addActionListener(new ControlsActionListener());
		JMenuItem hmItem = new JMenuItem("HM");
		hmItem.addActionListener(new hmActionListener());
		JMenuItem pokemonItem = new JMenuItem("Pokemon");
		pokemonItem.addActionListener(new pokemonActionListener());
		JMenuItem infoItem = new JMenuItem("Info");
		infoItem.addActionListener(new infoActionListener());
		JMenuItem seenItem = new JMenuItem("Seen");
		
		fileMenu.add(aboutItem);
		fileMenu.add(controlsItem);
		inventoryMenu.add(hmItem);
		inventoryMenu.add(pokemonItem);
		inventoryMenu.add(infoItem);
		pokedexMenu.add(seenItem);
		theMenuBar.add(fileMenu);
		theMenuBar.add(inventoryMenu);
		theMenuBar.add(pokedexMenu);
		this.setJMenuBar(theMenuBar);
    }
    
    //Adds all main components to the frame
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
	public static void addBattlePanel(){
		battlePanel = new BattlePanel(map);
		graphic.setViewportView(battlePanel);
	}
	
	//Swaps to map panel when a battle is over / homePanel is done
	public static void addMapPanel(){
		graphic.setViewportView(mapPanel);
		mapPanel.comeBack();
	}
	
    //Listener for about file item to give the player info about the project
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
	
	//Listener for Controls file item to show player the controls
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
	private class hmActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new BorderLayout());
		
			JLabel surf = new JLabel("You do not have HM Surf...");
			JLabel rockSmash = new JLabel("You do not have HM Rock Smash...");
			
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
	public static void main(String[] args) {
		new GameView();
	}
	
}
