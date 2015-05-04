package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Battle;
import model.Blastoise;
import model.Pokemon;

public class BattleView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel battleAction, buttons, meters, panelToReturn;
	JLabel catchRateLabel, runRateLabel, turnsLeftLabel;
	JSlider catchRateSlider, runRateSlider, turnsLeftSlider;
	Battle battle;
	Pokemon pokemon;
	JButton throwBait, throwSafariBall, throwRock, runAway;
	private Image image;

	public BattleView(Pokemon tempPokemon)
	{
		try {
			image = ImageIO.read(new File("Images/Trainer/TrainerRight.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new JPanel();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//terminates the program when close button is tapped
        //setting the title
        //setTitle("Battle");
        setLayout(new BorderLayout());
        pokemon = tempPokemon;
        battle = new Battle(pokemon);
        battleAction = new JPanel(){
				private static final long serialVersionUID = 1L;
				public void paintComponent(Graphics g){
        			super.paintComponent(g);
        			draw(g);
        	}
        };
        battleAction.setPreferredSize(new Dimension(300,200));
        setSize(500,300);
        buttons = new JPanel(new GridLayout(2,2));
        throwBait = new JButton("Throw Bait");
        throwBait.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] result = battle.throwBait();
				runRateSlider.setValue(result[0]);
				catchRateSlider.setValue(result[1]);
				turnsLeftSlider.setValue(result[2]);
				
				if(result[3] == -1)
					System.out.println("You Lose");
				else if(result[3] == 1)
					System.out.println("You Win");
				
				// TODO Auto-generated method stub
				
			}});
        throwSafariBall = new JButton("Throw Safari Ball");
        throwSafariBall.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] result = battle.throwPokeball();
				runRateSlider.setValue(result[0]);
				catchRateSlider.setValue(result[1]);
				turnsLeftSlider.setValue(result[2]);
				
				if(result[3] == -1)
					System.out.println("You Lose");
				else if(result[3] == 1)
					System.out.println("You Win");
				// TODO Auto-generated method stub
				
			}});
        throwRock = new JButton("Throw Rock");
        throwRock.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int[] result = battle.throwRock();
				runRateSlider.setValue(result[0]);
				catchRateSlider.setValue(result[1]);
				turnsLeftSlider.setValue(result[2]);
				
				if(result[3] == -1)
					System.out.println("You Lose");
				else if(result[3] == 1)
					System.out.println("You Win");
				// TODO Auto-generated method stub
				
			}});
        runAway = new JButton("Run Away");
        runAway.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//battle.runAway();
				// TODO Auto-generated method stub
				
			}});
        buttons.add(throwBait);
        buttons.add(throwRock);
        buttons.add(throwSafariBall);
        buttons.add(runAway);
        catchRateLabel = new JLabel("CatchRate:");
        runRateLabel = new JLabel("Run Rate:");
        turnsLeftLabel = new JLabel("Turns Left:");
        catchRateSlider = new JSlider(0, 100, pokemon.getCatchRate());
        turnsLeftSlider = new JSlider(0, 5, pokemon.getMaxTurns());
        runRateSlider = new JSlider(0, 100, pokemon.getRunChance());
        meters = new JPanel(new GridLayout(3,2));
        meters.add(catchRateLabel);
        meters.add(catchRateSlider);
        
        meters.add(runRateLabel);
        meters.add(runRateSlider);
        
        meters.add(turnsLeftLabel);
        meters.add(turnsLeftSlider);
        
        add(battleAction, BorderLayout.CENTER);
        add(meters, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
        setVisible(true);
        
        panelToReturn = new JPanel();
        panelToReturn.add(this);
        
	}
	
	public JPanel getBattlePanel()
	{
		return panelToReturn;
	}
	public void draw(Graphics g)
	{
		//don't know the coordinates yet
		g.drawImage(image, 0, 0, null);
		g.drawImage(image, 50, 0, null);
		
	}
}
