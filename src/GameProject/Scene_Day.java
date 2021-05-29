package GameProject;

import GameProject.Scene.SCENE_TYPE;

public class Scene_Day extends Scene{
	

	public Scene_Day() {
		super("Day");
	}

	@Override
	public void GameObjInit() {
		GLabel daylabel = new GLabel("Day " + Scene.common_info.get("day"), Main.WCENTER - 102, Main.HCENTER - 102, 250, 80, 60, frame);
		Addobj(daylabel);
		Timer.setTimeout(() -> main_Routine.GetInstance().NextScene(SCENE_TYPE.GAME), 2000);
		int old_day = (int)Scene.common_info.get("day");
//		System.out.println("after day " + Scene.common_info.get("day"));
	}
}
