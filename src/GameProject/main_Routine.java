package GameProject;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class main_Routine extends JPanel{
	private Scene scene = new Scene_Intro();
	private Image screenImage;
	private Graphics screenGraphic;
	
	public main_Routine() {
		setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
		setLayout(null);
		Scene.SetFrame(this);
		scene.GameObjInit();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.WIDTH, Main.HEIGHT);
		screenGraphic = screenImage.getGraphics();
		draw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void draw(Graphics2D g) {
		scene.Render(g);
		paintComponents(g);
	}
}
