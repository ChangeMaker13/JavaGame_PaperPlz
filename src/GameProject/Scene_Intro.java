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
				"intro_startBtn_pressed.PNG", frame, 50, 50, 160, 80,
				(event) -> {
					main_Routine.GetInstance().NextScene(SCENE_TYPE.GAME);
				});
		Addobj(startBtn);
		
		// 아래 button event 구현 안됨.
		GButton endBtn = new GButton("intro_endBtn_normal.PNG",
				"intro_endBtn_pressed.PNG", frame, 50, 210, 110, 80,
				(event) -> {
					System.exit(1);
				});
		Addobj(endBtn);
		
		GButton loadBtn = new GButton("intro_loadBtn_normal.PNG",
				"intro_loadBtn_pressed.PNG", frame, 50, 130, 140, 80,
				(event) -> {
					main_Routine.GetInstance().NextScene(SCENE_TYPE.GAME);
				});
		Addobj(loadBtn);
		
		GButton helpBtn = new GButton("intro_helpBtn_normal.PNG",
				"intro_helpBtn_pressed.PNG", frame, 930, 50, 40, 80,
				(event) -> {
					main_Routine.GetInstance().NextScene(SCENE_TYPE.GAME);
				});
		Addobj(helpBtn);
		
		
	}
}
