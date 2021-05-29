package GameProject;

import GameProject.Scene.SCENE_TYPE;

public class Scene_Day extends Scene{
	
	int day = 1;

	public Scene_Day() {
		super("Day");
	}

	@Override
	public void GameObjInit() {
		GLabel daylabel = new GLabel("Day " + day, Main.WCENTER - 102, Main.HCENTER - 102, 200, 80, 60, frame);
		Addobj(daylabel);
		day++;
		Timer.setTimeout(() -> main_Routine.GetInstance().NextScene(SCENE_TYPE.GAME), 2000);
		
	}
}
