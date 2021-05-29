package GameProject;

import GameProject.Scene.SCENE_TYPE;

public class Scene_Game extends Scene{
	public Scene_Game() {
		super("Game");
	}

	@Override
	public void GameObjInit() {
		
		//GameFlowMgr�߰�
		GgameFlowMgr flowmgr = new GgameFlowMgr(this);
		Addobj(flowmgr);
		
		//Timer text�߰�
		GLabel timerText = new GLabel("TIMETEXT ERROR", Main.WIDTH -150, 0,150, 50, 24, frame);
		Addobj(timerText);
		flowmgr.SetTimerText(timerText);
		
		GEntrant entrant = new GEntrant(flowmgr.entrantsDataMgr.getRandomEntrant(), this, flowmgr);
		Addobj(entrant);
	}
}
