package BlockBreaker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JPanel;

public class Brick extends Rectangle{
		
		Image img;
		int dx = 3;
		int dy = -3;
		boolean destroyed;
		
		Brick(int a, int b, int w, int h, String str)
		{
			x = a;
			y = b;
			width = w;
			height = h;
			img = Toolkit.getDefaultToolkit().getImage(str);
		}
		
		public void draw(Graphics g, Component c)
		{
			if(!destroyed)
				g.drawImage(img, x, y, width, height, c);
		}
	
}
