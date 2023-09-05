package BrickGame;

import javax.swing.JFrame;

public class Main {
	public static void main (String args[]) {
		Gameplay gameplay = new Gameplay(); // Object is Created So That it can be passed in J Frame
		//Creating J Frame For The Game and Setting the Properties
		JFrame obj = new JFrame();
		obj.setBounds(10,10 , 700 , 600);
		obj.setTitle("Brick Out Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}

}
