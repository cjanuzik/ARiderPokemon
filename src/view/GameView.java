package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicArrowButton;

import model.Dir;
import model.Map;
import model.Tile;

public class GameView extends JFrame implements Observer, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -308984420263715300L;
	private GraphicPanel graphic; // graphic view
	//private Panel2 text; // text view
	private Map map;
	private JPanel controls, views;
	private BasicArrowButton up, down, right, left;

	public GameView() {
		setTitle("Pokemon - Safari Zone");
		map = new Map();
		layoutGUI();
		registerListeners();
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		map.addObserver(this); //this does the observing
	}

	public void layoutGUI() {
		makeAndLayoutViews();
		makeControlls();
		setLayoutAndAddComponentsToFrame();
	}

	private void makeAndLayoutViews() {
		graphic = new GraphicPanel(map);
		//text = new Panel2(map);
		views = new JPanel(new BorderLayout());

		views.add(graphic, BorderLayout.WEST);
		//views.add(text, BorderLayout.EAST);
	}

	private void setLayoutAndAddComponentsToFrame() {
		this.setLayout(new BorderLayout());
		this.add(views, BorderLayout.NORTH);
		this.add(controls, BorderLayout.SOUTH);
	}

	private void makeControlls() {
		controls = new JPanel(new GridLayout(2, 4));
		up = new BasicArrowButton(BasicArrowButton.NORTH);
		down = new BasicArrowButton(BasicArrowButton.SOUTH);
		right = new BasicArrowButton(BasicArrowButton.EAST);
		left = new BasicArrowButton(BasicArrowButton.WEST);

		controls.add(new JPanel()); // add empty panels to make the buttons look
									// right
		controls.add(up);
		controls.add(new JPanel()); // add empty panels to make the buttons look
									// right
		controls.add(left);
		controls.add(down);
		controls.add(right);
		controls.setPreferredSize(new Dimension(200, 100));
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
