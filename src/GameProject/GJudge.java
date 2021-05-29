package GameProject;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GJudge extends GameObject{
	private Scene scene;
	
	private GButton accept_btn;
	private GButton deny_btn;
	private GEntrant judge_objective;

	public GJudge(Scene scene, GEntrant judge_objective) {
		super(Type.ETC);
		this.scene = scene;
		this.judge_objective = judge_objective;
		
		//accept button
		accept_btn = new GButton("accept_normal.jpg",
				"accept_pressed.jpg", scene.frame, 450, 450, 200, 75,
				(event) -> {
					 AcceptEntrant();
				});
		scene.Addobj(accept_btn);
		
		//denied button
		deny_btn = new GButton("denied_normal.jpg",
				"denied_pressed.jpg", scene.frame, 700, 450, 200, 75,
				(event) -> {
					 DenyEntrant();
				});
		scene.Addobj(deny_btn);
	}
	
	public void AcceptEntrant() {
		GPassport pass = judge_objective.getPassport();
		Image stampImage = new ImageIcon(getClass().getClassLoader().getResource("accept_pressed.jpg")).getImage();
		pass.SetStamp(stampImage);
		scene.RemoveObj(this);
		Timer.setTimeout(() -> scene.RemoveObj(judge_objective), 1000);
	}
	
	public void DenyEntrant() {
		GPassport pass = judge_objective.getPassport();
		Image stampImage = new ImageIcon(getClass().getClassLoader().getResource("denied_pressed.jpg")).getImage();
		pass.SetStamp(stampImage);
		scene.RemoveObj(this);
		Timer.setTimeout(() -> scene.RemoveObj(judge_objective), 1000);
	}

	@Override
	public void Destroy() {
		accept_btn.Destroy();
		deny_btn.Destroy();
	}
}
