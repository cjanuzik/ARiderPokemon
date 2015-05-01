package controller;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import objects.Trainer;
import objects.SpriteObject;


public class PokemonController {
	private TreeSet<Character> keySet;
	private SpriteObject trainer;
	private JFrame frame;
	private JPanel panel;
	private Timer animTimer;
	
	
	public PokemonController() {
		keySet = new TreeSet<Character>();
		trainer = new Trainer(400, 300);
		trainer.start();
		
		// creates the panel that actually draws the sprites
		panel = new JPanel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = -968649436766507053L;

			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				trainer.draw(g);

			}
		};
		panel.setPreferredSize(new Dimension(800, 600));
		
		// creates the timer for animating the panel
		animTimer = new Timer(15, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (trainer != null){ // move the trainer according to what keys are being pressed
					if (keySet.contains('w'))
						trainer.moveUp();
					else if (keySet.contains('a'))
						trainer.moveLeft();
					else if (keySet.contains('s'))
						trainer.moveDown();
					else if (keySet.contains('d'))
						trainer.moveRight();
					else
						trainer.moveStop();
				}
				
				panel.repaint();
			}
			
		});
		
		frame = new JFrame();
		frame.add(panel);
		frame.setTitle("ARiderPokemon");
		frame.setJMenuBar(new MyJMenuBar());
		
		frame.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent arg0) {
				keySet.add(arg0.getKeyChar());
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {keySet.remove(arg0.getKeyChar());}
		});
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		animTimer.start();
	}
	
	private class MyJMenuBar extends JMenuBar {

        private static final long serialVersionUID = 1L;
        private JMenu fileMenu;
        private JMenuItem exitMenuItem;
        private JMenuItem aboutMenuItem;
        private JMenuItem inventoryDisplay;

        public MyJMenuBar() {
        	//Creating file menu and adding About and Exit menuItems into it
            fileMenu = new JMenu("File");
            exitMenuItem = new JMenuItem("Exit");
            aboutMenuItem = new JMenuItem("About");
            inventoryDisplay = new JMenuItem("Inventory");
            //calling the required ActionListener class when the buttons are tapped
            inventoryDisplay.addActionListener(new myInventoryDispayListener());
            exitMenuItem.addActionListener(new MyExitListener());
            aboutMenuItem.addActionListener(new MyAboutListener());
            fileMenu.add(inventoryDisplay);
            fileMenu.add(aboutMenuItem);
            fileMenu.add(exitMenuItem);
            this.add(fileMenu);
        }
        
	}
	private class myInventoryDispayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			JOptionPane.showMessageDialog(null, "Inventory to be displayed here", "Inventory",JOptionPane.INFORMATION_MESSAGE);;
		}
	}
	private class MyExitListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
        	int result = JOptionPane.showConfirmDialog(null, "So you want to exit pokemon game?", "Exit ARiderPokemon?", JOptionPane.YES_NO_OPTION);
        	if(result == JOptionPane.YES_OPTION)
        		System.exit(0);
        }
      }
	private class MyAboutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			//dialog box created
			JOptionPane.showMessageDialog(null,"CSc335 Final Project");
		}
	}

	
	public static void main(String[] args){
		new PokemonController();
	}
}
