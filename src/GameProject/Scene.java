package GameProject;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Scene {
	public enum SCENE_TYPE{
		INTRO,
		GAME
	}
	
	public static JPanel frame;
	
	protected String SceneName;
	protected ArrayList<GameObject> gRenderable = new ArrayList<GameObject>();
	
	
	public Scene(String name) {
		SceneName = name;
	}
	public static void SetFrame(JPanel fra) {
		frame = fra;
	}

	public void Addobj(GameObject obj) {
		gRenderable.add(obj);
	}
	
	public void Render(Graphics2D g) {
		for(int i = 0; i < gRenderable.size(); i++) {
			gRenderable.get(i).Render(g);
		}
	}
	
	public abstract void GameObjInit();
}
