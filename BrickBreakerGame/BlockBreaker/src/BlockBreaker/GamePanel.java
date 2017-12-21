package BlockBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener{
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		ArrayList<Brick>ball = new ArrayList<Brick>();
		int size = 25;
		Brick paddle;
		Thread thread;
		Animate animate;
		int totalBricks = 32;
		int score = 0;

		
		GamePanel()
		{
			paddle = new Brick(175,480,150,25,"images/gray.png");
			ball.add(new Brick(237,437,20,20,"images/ball.png"));
			for(int i=0; i<8; i++)
				bricks.add(new Brick((i*60+2),0,60,25,"images/purple.png"));			
			for(int i=0; i<8; i++)
				bricks.add(new Brick((i*60+2),25,60,25,"images/blue.png"));
			for(int i=0; i<8; i++)
				bricks.add(new Brick((i*60+2),50,60,25,"images/red.png"));
			for(int i=0; i<8; i++)
				bricks.add(new Brick((i*60+2),75,60,25,"images/green.png"));
			addKeyListener(this);
			
			setFocusable(true);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			for(Brick b : bricks)
				b.draw(g, this);
			for(Brick b: ball){
				b.draw(g, this);
			}
			paddle.draw(g, this);
			
		}

		public void update(){
			for(Brick ba:ball){
				ba.x += ba.dx;					
				if(ba.x>(getWidth()-size)&&ba.dx>0 || ba.x<0)
					ba.dx*=-1;
				if(ba.y<0||ba.intersects(paddle))
					ba.dy*=-1;
				ba.y+=ba.dy;
								
				for(Brick br:bricks){
					if(ba.intersects(br) && !br.destroyed){
						br.destroyed=true;
						ba.dy*=-1;
						totalBricks--;
						score += 5;
					if(totalBricks==0)
						JOptionPane.showMessageDialog(null, "You Win");
					}
				}
			}
			repaint();
		}
		
		
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==KeyEvent.VK_LEFT)
				paddle.x-=15;
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
				paddle.x+=15;
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				animate = new Animate(this);
				thread = new Thread(animate);
				thread.start();
				}
			if(e.getKeyCode() == KeyEvent.VK_LEFT && paddle.x>0)
				paddle.x-=15;
			if(e.getKeyCode()==KeyEvent.VK_RIGHT && paddle.x<(getWidth()-paddle.width))
				paddle.x+=15;
			if(e.getKeyCode()==KeyEvent.VK_RIGHT && paddle.x>(getWidth()))
				paddle.x*=-1;
				
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

}
