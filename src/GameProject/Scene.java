package GameProject;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;


public abstract class Scene {
	public enum SCENE_TYPE{
		INTRO,
		GAME
	}
	
	public static JPanel frame;
	
	protected String SceneName;
	protected ArrayList<GameObject> gObjects = new ArrayList<GameObject>();
	
	//Renderable interface를 상속한 object에 대한 reference를 따로 가지고 있음
	protected ArrayList<Renderable> gRenderable = new ArrayList<Renderable>();
	protected ArrayList<Movable> gMovable = new ArrayList<Movable>();
	
	//movable object의 progress를 주기적으로 실행시켜주기 위한 thread
	private ScheduledExecutorService scheduleService = 
			Executors.newScheduledThreadPool(1);
	private Runnable frameAction = new Runnable() {
		@Override
		public void run() {
			FrameAction();
		}
	};
	
	public Scene(String name) {
		SceneName = name;
		scheduleService.scheduleAtFixedRate(frameAction, 0, 10, TimeUnit.MILLISECONDS);
	}
	public static void SetFrame(JPanel fra) {
		frame = fra;
	}

	public void Addobj(GameObject obj) {
		gObjects.add(obj);
		
		if(obj instanceof Renderable) {
			gRenderable.add((Renderable)obj);
		}
		if(obj instanceof Movable) {
			gMovable.add((Movable)obj);
		}
	}
	
	public void RemoveObj(GameObject obj) {
		obj.Destroy();
		System.out.println(gObjects.remove(obj));
		
		if(obj instanceof Renderable) {
			System.out.println(gRenderable.remove(obj));
		}
		if(obj instanceof Movable) {
			System.out.println(gMovable.remove(obj));
		}
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
	
	public void FrameAction() {
		for(int i = 0; i < gMovable.size(); i++) {
			gMovable.get(i).Progress();
		}
	}
	
	public void DestroyScene() {
		 Iterator<GameObject> iter = gObjects.iterator();
		 while(iter.hasNext()) {
			 GameObject obj = iter.next();
			 obj.Destroy();
		 }
		 gObjects.clear();
	}
	
	public abstract void GameObjInit();
}
