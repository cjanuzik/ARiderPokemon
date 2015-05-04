package controller;

import java.awt.BorderLayout;
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
import model.Inventory;
import model.Map;

public class GameView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -308984420263715300L;
	private static JPanel master;
	private static BattlePanel battlePanel;
	private static GraphicPanel mapPanel;
	private static JScrollPane graphic; // graphic view
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JPanel mainPanel;
	private static Map map;
	private static Inventory inventory;
	private JLabel GBCTop, GBCLeft, GBCRight, GBCBottom;
	//private JPanel views;
	
	public GameView() {
		setTitle("Pokemon - Safari Zone");
		map = new Map();
		inventory = new Inventory();
		loadImages();
		master = new JPanel();
		mapPanel = new GraphicPanel(map);
		battlePanel = new BattlePanel(map);
		master.add(mapPanel);
		master.add(battlePanel);
		graphic = new JScrollPane(master);
		graphic.setViewportView(mapPanel);
		layoutGUI();
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
    
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
	
	public void layoutGUI() {
		makeAndLayoutViews();
		setLayoutAndAddComponentsToFrame();
	}

	private void makeAndLayoutViews() {
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
   
	private void setLayoutAndAddComponentsToFrame() {
		this.setLayout(new BorderLayout());
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
		JMenuItem infoItem = new JMenuItem("Info");
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
		
		this.add(mainPanel, BorderLayout.NORTH);
	}
    
	public static void addBattlePanel(){
		battlePanel = new BattlePanel(map);
		graphic.setViewportView(battlePanel);
	}
	
	public static void addMapPanel(){
		graphic.setViewportView(mapPanel);
		mapPanel.comeBack();
	}
	
	

    
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
	
	private class hmActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new BorderLayout());
		
			JLabel surf = new JLabel("You do not have HM Surf...");
			JLabel rockSmash = new JLabel("You do not have HM Rock Smash...");
			
			if(inventory.getSurfUnlocked())
				surf = new JLabel("You have unlocked HM Surf!");
			if(inventory.getRockSmashUnlocked())
				rockSmash = new JLabel("You have unlocked HM Rock Smash!");
			
			panel.add(surf, BorderLayout.NORTH);
			panel.add(rockSmash, BorderLayout.CENTER);
			
			JOptionPane.showMessageDialog(null, panel);
		}
	}
	
	public static void main(String[] args) {
		new GameView();
	}
	
}
