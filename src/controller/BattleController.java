package controller;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class JavaController extends JFrame {
	JPanel battleAction, buttons;
	JButton throwBait, throwSafariBall, throwRock, runAway;
	private Image image;

	public JavaController()
	{
		try {
			image = ImageIO.read(new File("Images/Trainer/TrainerRight.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new JFrame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//terminates the program when close button is tapped
        //setting the title
        setTitle("Battle");
        setLayout(new BorderLayout());
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
        throwSafariBall = new JButton("Throw Safari Ball");
        throwRock = new JButton("Throw Rock");
        runAway = new JButton("Run Away");
        buttons.add(throwBait);
        buttons.add(throwRock);
        buttons.add(throwSafariBall);
        buttons.add(runAway);
        add(battleAction, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);
        setVisible(true);
        
	}
	public void draw(Graphics g)
	{
		//don't know the coordinates yet
		g.drawImage(image, 0, 0, null);
		g.drawImage(image, 50, 0, null);
		
	}
	public static void main(String[] args)
	{
		new JavaController();
	}
	

}
