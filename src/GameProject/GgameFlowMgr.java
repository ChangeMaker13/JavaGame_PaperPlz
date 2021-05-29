package GameProject;

import java.awt.Container;

import GameProject.Scene.SCENE_TYPE;

public class GgameFlowMgr extends GameObject 
implements Movable{
	public static final int SECINDAY = 20;
	public static final int MAXDAY = 1;

	public EntrantsDataMgr entrantsDataMgr;
	private int curday;
	private Timer timer;
	private GLabel timer_text;	//ref
	private Scene game_scene; 	//ref
	
	public GgameFlowMgr(Scene scene) {
		super(Type.ETC);
		curday = 1;
		timer = new Timer();
		timer.Start(SECINDAY);
		entrantsDataMgr = new EntrantsDataMgr();
		game_scene = scene;
	}
	
	public void SetTimerText(GLabel label) {
		timer_text = label;
	}
	
	@Override
	public void Progress() {
		TimeCheck();
	}
	
	private void TimeCheck() {
		if(curday > MAXDAY) {
			main_Routine.GetInstance().NextScene(SCENE_TYPE.ENDING);
		}
		else {
		int remain = timer.GetRemain();
		if(remain <= 0) {
			curday += 1;
			timer.Start(SECINDAY);
		}
		String str = Integer.toString(curday) + " Day, " + Integer.toString(remain);
		timer_text.resetText(str);
		}
	}
	
	public void GenerateNewEntrant() {
		GEntrant entrant = new GEntrant(entrantsDataMgr.getRandomEntrant(), game_scene, this);
		game_scene.Addobj(entrant);
	}

	@Override
	public void Destroy() {
	}
}
