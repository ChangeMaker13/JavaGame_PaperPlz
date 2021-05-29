package GameProject;

public class Scene_Ending extends Scene {
	private static final int PromotionScore = 20;
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
		
		int totalScore = (int)Scene.common_info.get("score");
		
		if(totalScore < 0)
			ResultText = "<html><br>SUSPENDED!!</html>";
		else if(totalScore > PromotionScore) {
			ResultText = "<html>You have got promoted<br>Congratulations!</html>";
		}
		else {
			ResultText = "<html>You're ganna Fired<br>FuckYou!</html>";
		}
		GLabel result = new GLabel(ResultText, 20, 20, Main.WIDTH - 300, 400, 40, frame);
		Addobj(result);
		
		//Main menu button
		GButton MainmenuBtn = new GButton("mainmenu_normal.PNG",
				"mainmenu_pressed.PNG", frame, Main.HEIGHT - 150, Main.WCENTER - 100, 160, 140,
				(event) -> {
					main_Routine.GetInstance().NextScene(SCENE_TYPE.INTRO);
				});
		Addobj(MainmenuBtn);

	}
}

