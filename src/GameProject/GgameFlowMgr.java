package GameProject;

import java.awt.Container;

import GameProject.Scene.SCENE_TYPE;

public class GgameFlowMgr extends GameObject 
implements Movable{
	public static final int SECINDAY = 10;
	public static final int MAXDAY = 5;

	public EntrantsDataMgr entrantsDataMgr;
	private int curday;
	private Timer timer;
	private GLabel timer_text;	//ref
	
	public GgameFlowMgr() {
		super(Type.ETC);
		curday = 1;
		timer = new Timer();
		timer.Start(SECINDAY);
		entrantsDataMgr = new EntrantsDataMgr();
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
			main_Routine.GetInstance().NextScene(SCENE_TYPE.DAY);	
		}
		String str = Integer.toString(curday) + " Day, " + Integer.toString(remain);
		timer_text.resetText(str);
		}
	}

	@Override
	public void Destroy() {
	}
}
