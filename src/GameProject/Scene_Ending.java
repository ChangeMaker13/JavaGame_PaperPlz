package GameProject;

public class Scene_Ending extends Scene {
	private static int PromotionScore;
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
		
		int totalScore = 300;
		int Betrayer = 4;
		if(totalScore < 0)
			ResultText = "SUSPENDED!!";
		else if(totalScore > 200)
			ResultText = "<html>You have got promoted<br>Congratulations!</html>";
		else {
			ResultText = "You're ganna Fired\nFuckYou!";
		}
		GLabel result = new GLabel(ResultText, 20, 20, Main.WIDTH - 300, 400, 40, frame);
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

