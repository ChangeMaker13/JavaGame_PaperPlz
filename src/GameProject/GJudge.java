package GameProject;

import java.awt.Container;

import GameProject.Scene.SCENE_TYPE;

public class GJudge extends GameObject{
	private Scene scene;
	
	private GButton accept_btn;
	private GButton deny_btn;
	private GPassport judge_objective;

	public GJudge(Scene scene) {
		super(Type.ETC);
		this.scene = scene;
		
		//accept button
		accept_btn = new GButton("accept_normal.jpg",
				"accept_pressed.jpg", scene.frame, 450, 450, 200, 75,
				(event) -> {
					 int a = 10;
				});
		scene.Addobj(accept_btn);
		
		//denied button
		deny_btn = new GButton("denied_normal.jpg",
				"denied_pressed.jpg", scene.frame, 700, 450, 200, 75,
				(event) -> {
					 int a = 10;
				});
		scene.Addobj(deny_btn);
	}

	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		
	}
}
