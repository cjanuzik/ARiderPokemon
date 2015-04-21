package view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Map;

public class Panel2 extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6425413722609154458L;
	private Map map;
	//TODO: Declare any components you want to use

	public Panel2(Map map) {
		this.map = map;
		//TODO: Initialize components and add them to the panel
		map.addObserver(this);
		this.setPreferredSize(new Dimension(300, 450));
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
        
	    System.out.println("Panel2 Updated");
	    this.repaint();
	}


}
