package GameProject;

public class Scene_Game extends Scene{
	public Scene_Game() {
		super("Game");
	}

	@Override
	public void GameObjInit() {
		//score, day init
		Scene.common_info.put("score", 0);
		Scene.common_info.put("day", 0);
		
		//GameFlowMgr�߰�
		GgameFlowMgr flowmgr = new GgameFlowMgr(this);
		Addobj(flowmgr);
		
		//Timer text�߰�
		GLabel timerText = new GLabel("TIMETEXT ERROR", Main.WIDTH -150, 0,150, 50, 24, frame);
		Addobj(timerText);
		flowmgr.SetTimerText(timerText);
		
		//test
		//GEntrant one = new GEntrant(new EntrantData("park", "korea", "busan", "male"), this);
		//Addobj(one);
		
		GEntrant entrant = new GEntrant(flowmgr.entrantsDataMgr.getRandomEntrant(), this, flowmgr);
		Addobj(entrant);
	}
}
