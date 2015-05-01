package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicArrowButton;

import model.Dir;
import model.Map;
import model.Tile;

public class GameView2 extends JFrame implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -308984420263715300L;
	private GraphicPanel graphic; // graphic view
	//private Panel2 text; // text view
	private TreeSet<Character> keySet;
	private Map map;
	private JPanel views;
	private Timer animTimer;

	public GameView2() {
		
		keySet = new TreeSet<Character>();
		
		setTitle("Pokemon - Safari Zone");
		map = new Map();
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		map.addObserver(this); //this does the observing
		
		graphic = new GraphicPanel(map);
		//text = new Panel2(map);
		views = new JPanel();
		views.setPreferredSize(new Dimension(800,600));

		views.add(graphic, BorderLayout.WEST);
		//views.add(text, BorderLayout.EAST);
		
		this.setLayout(new BorderLayout());
		this.add(views, BorderLayout.NORTH);
		
		animTimer = new Timer(15, new ActionListener(){
		public void actionPerformed(ActionEvent arg0) { // move the trainer according to what keys are being pressed
			if (keySet.contains('w'))
				map.move(Dir.UP, graphic);
			else if (keySet.contains('a'))
				map.move(Dir.LEFT, graphic);
			else if (keySet.contains('s'))
				map.move(Dir.DOWN, graphic);
			else if (keySet.contains('d'))
				map.move(Dir.RIGHT, graphic);
			
			views.repaint();
	}});

		
		this.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				keySet.add(arg0.getKeyChar());
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {keySet.remove(arg0.getKeyChar());}
		});
	}



	public static void main(String[] args) {
		new GameView2();
	}


	
	@Override
	public void update(Observable o, Object arg) { //must cast arg to keep its object type
		// TODO Auto-generated method stub
		this.repaint();
	}
}
