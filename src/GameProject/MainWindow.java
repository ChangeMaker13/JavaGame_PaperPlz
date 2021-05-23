package GameProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame{
	main_Routine gameWindow;
	
	public MainWindow() {
		// TODO Auto-generated constructor stub
		super("paper plz");
		setSize(Main.WIDTH, Main.HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new GridLayout(1,1));

		gameWindow = new main_Routine();
		add(gameWindow);
	}
	
	@Override
	public void paint(Graphics g) {
		paintComponents(g);
		repaint();
	}
}
