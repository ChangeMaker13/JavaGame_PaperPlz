package GameProject;

public class Scene_Intro extends Scene {
	public Scene_Intro() {
		super("Intro");
	}

	@Override
	public void GameObjInit() {
		//background
		GImage background = new GImage("intro_Background.png",0,0);
		Addobj(background);
		
		//start button
		GButton startBtn = new GButton("intro_startBtn_normal.PNG",
				"intro_startBtn_pressed.PNG", frame, 50, 50, 150, 80,
				(event) -> {
					main_Routine.GetInstance().NextScene(SCENE_TYPE.GAME);
				});
		Addobj(startBtn);
	}
}
