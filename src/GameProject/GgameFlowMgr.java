package GameProject;

public class GgameFlowMgr extends GameObject 
implements Movable{
	public static final int SECINDAY = 10;
	public static final int MAXDAY = 2;
	
	private int curday;
	private Timer timer;
	private GLabel timer_text;	//ref

	public GgameFlowMgr() {
		super(Type.ETC);
		curday = 1;
		timer = new Timer();
		timer.Start(SECINDAY);
	}
	
	public void SetTimerText(GLabel label) {
		timer_text = label;
	}

	@Override
	public void Progress() {
		int remain = timer.GetRemain();
		if(remain <= 0) {
			curday += 1;
			timer.Start(SECINDAY);
		}
		
		String str = Integer.toString(curday) + " Day, " + Integer.toString(remain);
		timer_text.resetText(str);
	}
	
	@Override
	public void Destroy() {
	}
}
