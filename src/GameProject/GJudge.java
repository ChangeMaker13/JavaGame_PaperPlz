package GameProject;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GJudge extends GameObject{
	private static final int CORRECT_SCORE = 20;
	
	private Scene scene;
	
	private GButton accept_btn;
	private GButton deny_btn;
	private GEntrant judge_objective;
	
	private GgameFlowMgr game_mgr; //ref

	public GJudge(Scene scene, GEntrant judge_objective, GgameFlowMgr game_mgr) {
		super(Type.ETC);
		this.scene = scene;
		this.judge_objective = judge_objective;
		this.game_mgr = game_mgr;
		
		//accept button
		accept_btn = new GButton("accept_normal.jpg",
				"accept_pressed.jpg", scene.frame, 450, 450, 200, 75,
				(event) -> {
					JudgeEntrant("accept");
				});
		scene.Addobj(accept_btn);
		
		//denied button
		deny_btn = new GButton("denied_normal.jpg",
				"denied_pressed.jpg", scene.frame, 700, 450, 200, 75,
				(event) -> {
					JudgeEntrant("deny");
				});
		scene.Addobj(deny_btn);
	}
	
	public void JudgeEntrant(String judge) {
		String fileName = "accept_pressed.jpg";
		boolean match = judge_objective.IsMathWithPassPort();
		int old_score = (int)Scene.common_info.get("score");
		
		if(judge.equals("accept")) {
			fileName = "accept_pressed.jpg";
			if(match) Scene.common_info.put("score", old_score + CORRECT_SCORE);
			else Scene.common_info.put("score", old_score - CORRECT_SCORE);
		}
		else if(judge.equals("deny")) {
			fileName = "denied_pressed.jpg";
			if(!match) Scene.common_info.put("score", old_score + CORRECT_SCORE);
			else Scene.common_info.put("score", old_score - CORRECT_SCORE);
		}
		
		GPassport pass = judge_objective.getPassport();
		Image stampImage = new ImageIcon(getClass().getClassLoader().getResource(fileName)).getImage();
		pass.SetStamp(stampImage);
		scene.RemoveObj(this);
		Timer.setTimeout(() -> scene.RemoveObj(judge_objective), 1000);
		Timer.setTimeout(() -> scene.RemoveObj(judge_objective.getPassport()), 1000);
		Thread genThread = Timer.setTimeout(() -> game_mgr.GenerateNewEntrant(), 1000);
		scene.AddThread(genThread);
		System.out.println("score : " + (int)Scene.common_info.get("score"));
		
	}

	@Override
	public void Destroy() {
		accept_btn.Destroy();
		deny_btn.Destroy();
	}
	
}
