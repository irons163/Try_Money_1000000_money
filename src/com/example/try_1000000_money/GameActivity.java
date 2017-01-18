package com.example.try_1000000_money;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.try_1000000_money.utils.AudioUtil;
import com.example.try_1000000_money.utils.CommonUtil;
import com.example.try_gameengine.framework.Config;
import com.example.try_gameengine.framework.Config.DestanceType;
import com.example.try_gameengine.scene.SceneManager;
import com.example.try_gameengine.stage.Stage;

public class GameActivity extends Stage{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		BitmapUtil.initBitmap(this);
		AudioUtil.init(this);
		initStage();
	}
	
	@Override
	public SceneManager initSceneManager() {
		// TODO Auto-generated method stub
		SceneManager sceneManager = new SceneManager();
		GameScene gameScene = new GameScene(this, "0", 0);
		sceneManager.addScene(gameScene);
		sceneManager.startScene(0);
		return sceneManager;
	}

}
