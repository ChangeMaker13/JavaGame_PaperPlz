package GameProject;

public class Scene_Ending extends Scene {
	public Scene_Ending() {
		super("End");
	}

	public void GameObjInit() {
		//background
		GImage background = new GImage("passport.jpg",0,0);
		//Addobj(background);

		//Ending text
		String ResultText = "";
		GLabel resultTag = new GLabel("Result", Main.WCENTER - 102, 20, 150, 50, 48, frame);
		Addobj(resultTag);
		
		ResultText += "SUSPENDED!!";
		GLabel result = new GLabel(ResultText, Main.WCENTER - 102,68, 150, 50 , 60, frame);
		Addobj(result);
		
		//Main menu button
		GButton MainmenuBtn = new GButton("intro_startBtn_normal.PNG",
				"intro_startBtn_normal.PNG", frame, Main.HEIGHT - 150, Main.WCENTER - 80, 150, 80,
				(event) -> {
					main_Routine.GetInstance().NextScene(SCENE_TYPE.INTRO);
				});
		Addobj(MainmenuBtn);

	}
}

