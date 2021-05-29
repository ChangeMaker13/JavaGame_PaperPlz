package GameProject;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GPassport extends GameObject implements Renderable{
	private final int OFFX = 450;
	private final int OFFY = 100;
	
	private EntrantData data;
	Image passport_frame;
	Image portrait;
	public GPassport(EntrantData data) {
		super(Type.ETC);
		passport_frame = new  ImageIcon(getClass().getClassLoader().getResource("passport.jpg")).getImage(); 
		portrait = new ImageIcon(getClass().getClassLoader().getResource(data.getName() +".jpg")).getImage();
	}
	
	@Override
	public void Render(Graphics2D g) {
		g.drawImage(passport_frame, OFFX, OFFY, 500,300, null);
		g.drawImage(portrait, OFFX+10, OFFY+70, 150,200, null);
	}

	@Override
	public void Destroy() {
	}
}
