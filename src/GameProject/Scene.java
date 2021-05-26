package GameProject;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	static public Scene MakeScene(SCENE_TYPE type) {
		Scene newScene;
		
		switch(type) {
		case INTRO:
			newScene = new Scene_Intro();
			break;
		case GAME:
			newScene = new Scene_Game();
			break;
		default:
			newScene = new Scene_Intro();
			break;
		}
		
		newScene.GameObjInit();
		return newScene;
	}
	
	public void DestroyScene() {
		 Iterator<GameObject> iter = gRenderable.iterator();
		 while(iter.hasNext()) {
			 GameObject obj = iter.next();
			 obj.Destroy();
		 }
		 gRenderable.clear();
	}
	
	public abstract void GameObjInit();
}
