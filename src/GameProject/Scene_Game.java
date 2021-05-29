package GameProject;

import GameProject.Scene.SCENE_TYPE;

public class Scene_Game extends Scene{
	public Scene_Game() {
		super("Game");
	}

	@Override
	public void GameObjInit() {
		
		//GameFlowMgr추가
		GgameFlowMgr flowmgr = new GgameFlowMgr();
		Addobj(flowmgr);
		
		//Timer text추가
		GLabel timerText = new GLabel("TIMETEXT ERROR", Main.WIDTH -150, 0,150, 50, 24, frame);
		Addobj(timerText);
		flowmgr.SetTimerText(timerText);
		
		//test
		//GEntrant one = new GEntrant(new EntrantData("park", "korea", "busan", "male"), this);
		//Addobj(one);
		
		System.out.println(flowmgr.entrantsDataMgr.getRandomEntrant().getName());
		GEntrant one = new GEntrant(flowmgr.entrantsDataMgr.getRandomEntrant(), this);
		Addobj(one);
		
		GJudge judge = new GJudge(this, one);
		Addobj(judge);
		
		if (GgameFlowMgr.SECINDAY == 0)
			main_Routine.GetInstance().NextScene(SCENE_TYPE.GAME);
	}
}
