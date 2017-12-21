package BlockBreaker;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		JFrame frame = new JFrame ("Brick Breaker Game");
		
		GamePanel panel = new GamePanel();
		frame.getContentPane().add(panel);
		
		frame.setSize(487,650);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
