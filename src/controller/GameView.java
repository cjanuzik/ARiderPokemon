package controller;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.GraphicPanel;
import model.Dir;
import model.Map;

public class GameView extends JFrame implements Observer, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -308984420263715300L;
	private GraphicPanel graphic; // graphic view
	private JPanel topPanel, centerPanel, bottomPanel, mainPanel;
	//private Panel2 text; // text view
	private Map map;
	private JLabel GBCTopL, GBCTop, GBCTopR, GBCLeft, GBCRight, GBCBotL, GBCBottom, GBCBotR;
	//private JPanel views;
	
	public GameView() {
		setTitle("Pokemon - Safari Zone");
		map = new Map();
		loadImages();
		layoutGUI();
		registerListeners();
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		map.addObserver(this); //this does the observing
	}
    
	public void loadImages(){
		try {
		    BufferedImage GBCComponent = ImageIO.read(new File("Images/GBC/GBCTopL.png"));
		    GBCTopL = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCTop.png"));
		    GBCTop = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCTopR.png"));
		    GBCTopR = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCLeft.png"));
		    GBCLeft = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCRight.png"));
		    GBCRight = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCBotL.png"));
		    GBCBotL = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCBottom.png"));
		    GBCBottom = new JLabel(new ImageIcon(GBCComponent));
		    GBCComponent = ImageIO.read(new File("Images/GBC/GBCBotR.png"));
		    GBCBotR = new JLabel(new ImageIcon(GBCComponent));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void layoutGUI() {
		makeAndLayoutViews();
		setLayoutAndAddComponentsToFrame();
	}

	private void makeAndLayoutViews() {
		graphic = new GraphicPanel(map);
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
		//mainPanel.add(GBCBotR);
	}
    public void goBattle(){
    	this.remove(graphic);
    }
	private void setLayoutAndAddComponentsToFrame() {
		this.setLayout(new BorderLayout());
		this.add(mainPanel, BorderLayout.NORTH);
	}

	private void registerListeners() {
		
		this.addKeyListener(this);
		
	}

	public static void main(String[] args) {
		new GameView();
	}
	
	@Override
	public void update(Observable o, Object arg) { //must cast arg to keep its object type
		// TODO Auto-generated method stub
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP)
			map.move(Dir.UP,  graphic);
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			map.move(Dir.LEFT,  graphic);
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			map.move(Dir.DOWN,  graphic);
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			map.move(Dir.RIGHT,  graphic);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
