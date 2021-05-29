package GameProject;

public class Scene_Game extends Scene{
	public Scene_Game() {
		super("Game");
	}

	@Override
	public void GameObjInit() {
		//GameFlowMgr�߰�
		GgameFlowMgr flowmgr = new GgameFlowMgr();
		Addobj(flowmgr);
		
		//Timer text�߰�
		GLabel timerText = new GLabel("TIMETEXT ERROR", Main.WIDTH -150, 0,150, 50, 24, frame);
		Addobj(timerText);
		flowmgr.SetTimerText(timerText);
		
		//test
		GEntrant one = new GEntrant(new EntrantData("park", "korea", "busan", "male"), this);
		Addobj(one);
	}
}
