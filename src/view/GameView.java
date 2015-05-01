package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Dir;
import model.Map;

public class GameView extends JFrame implements Observer, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -308984420263715300L;
	private GraphicPanel graphic; // graphic view
	//private Panel2 text; // text view
	private Map map;
	private JPanel views;

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
		setLayoutAndAddComponentsToFrame();
	}

	private void makeAndLayoutViews() {
		graphic = new GraphicPanel(map);
		views = new JPanel(new BorderLayout());

		views.add(graphic, BorderLayout.WEST);
	}

	private void setLayoutAndAddComponentsToFrame() {
		this.setLayout(new BorderLayout());
		this.add(views, BorderLayout.NORTH);
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
