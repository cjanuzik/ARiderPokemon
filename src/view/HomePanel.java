package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameView;

public class HomePanel extends JPanel{
	final public int MEWTWO_WIN = 1;
	final public int TEN_WIN = 2;
	final public int NO_WIN = 3;
	private int winChosen;
	
	JPanel rulesPanel, choicePanel;
	JButton mewtwoWin, tenWin, noWin;
	JLabel choose, rules0, rules1, rules2, lucky, normal, roam;
	public HomePanel(){
		winChosen = 0;
		layoutGUI();
		registerListeners();
	}
	
	private void layoutGUI(){
		makeAndLayoutViews();
		setLayoutAndAddComponentsToPanel();
	}

	private void makeAndLayoutViews(){
		mewtwoWin = new JButton("Lucky");
		tenWin = new JButton("Normal");
		noWin = new JButton("Free Roam");
		
		choose = new JLabel("Choose one of the following play styles:");
		rules0 = new JLabel("Rules:");
		rules1 = new JLabel("1) You have 500 steps.");
		rules2 = new JLabel("2) You have 30 Safari balls.");
		lucky = new JLabel("Catch the legendary Mewtwo!");
		normal = new JLabel("Catch a total of 10 Pokemon!");
		roam = new JLabel("See how many Pokemon you can catch!");
		
		rulesPanel = new JPanel(new GridLayout(4, 1));
		rulesPanel.add(rules0);
		rulesPanel.add(rules1);
		rulesPanel.add(rules2);
		rulesPanel.add(choose);
		
		choicePanel = new JPanel(new GridLayout(3, 2));
		choicePanel.add(mewtwoWin);
		choicePanel.add(lucky);
		choicePanel.add(tenWin);
		choicePanel.add(normal);
		choicePanel.add(noWin);
		choicePanel.add(roam);
	}
	
	private void setLayoutAndAddComponentsToPanel() {
		this.setPreferredSize(new Dimension(352, 352));
		this.setVisible(true);
		this.setLayout(new GridLayout(2,1));
		this.add(rulesPanel);
		this.add(choicePanel);
		
	}
	
	private void registerListeners(){
		ChoiceListener listen = new ChoiceListener();
		mewtwoWin.addActionListener(listen);
		tenWin.addActionListener(listen);
		noWin.addActionListener(listen);
	}
    
	
	private class ChoiceListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == mewtwoWin)
				winChosen = MEWTWO_WIN;
			
			if(e.getSource() == tenWin)
				winChosen = TEN_WIN;
			
			if(e.getSource() == noWin)
				winChosen = NO_WIN;
			
			GameView.addMapPanel();
		}
		
	}
}
