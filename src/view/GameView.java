package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

import model.Dir;
import model.Map;
import model.Tile;

/**
 * This class is the main JFrame for the map. It loads all the objects and adds
 * them together. I tried to make it BIC as much as possible
 * 
 * @author Hasanain Jamal
 *
 */
public class GameView extends JFrame implements Observer{
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
		ActionListener listen = new MoveListener();
		up.addActionListener(listen);
		down.addActionListener(listen);
		right.addActionListener(listen);
		left.addActionListener(listen);
	}

	public static void main(String[] args) {
		new GameView();
	}

	/**
	 * This class implements ActionListener and listens to the arrow buttons on
	 * the screen
	 * 
	 * @author Hasanain Jamal
	 *
	 */
	private class MoveListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == up) {
				map.move(Dir.UP);
			} else if (e.getSource() == down) {
				map.move(Dir.DOWN);
			} else if (e.getSource() == right) {
				map.move(Dir.RIGHT);
			} else if (e.getSource() == left) {
				map.move(Dir.LEFT);
			}
			
			Tile nextTile = map.tileAt(map.getC(), map.getR());
			boolean canEncounter = nextTile.getCanEncounter();
			
			if(canEncounter == true){
			    int encountered = (int) (Math.random() * 10);
			
			    if(encountered == 1){
				    System.out.println("You have encountered a wild Pokemon!");
			    }
			}
		}

	}

	@Override
	public void update(Observable o, Object arg) { //must cast arg to keep its object type
		// TODO Auto-generated method stub
		this.repaint();
	}
}
