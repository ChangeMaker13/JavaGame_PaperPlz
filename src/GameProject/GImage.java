package GameProject;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

public class GImage extends GameObject implements Renderable{
	private Image image;
	private int xpos;
	private int ypos;

	public GImage(String fileName, int x, int y) {
		super(Type.Image);

		image = new ImageIcon(getClass().getClassLoader().getResource(fileName)).getImage(); 
		xpos = x;
		ypos = y;
	}
	
	public void Render(Graphics2D g) {
		g.drawImage(image, xpos, ypos, null);
	}
	
	public void setPos(int x, int y) {
		xpos = x;
		ypos = y;
	}
	
	
	public int getWidth() {
		return image.getWidth(null);
	}
	
	public int getHeight() {
		return image.getHeight(null);
	}

	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		
	}
}
