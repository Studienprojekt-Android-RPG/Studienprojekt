package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnemyAtk {

	private TextureAtlas hit;
	Animation eh1, lh1;
	TextureRegion currentFrame;
	static boolean enemyATK;
	float stateTime;
	
public  EnemyAtk(){	
	
	hit = new TextureAtlas(Gdx.files.internal("hit.atlas"));	
	eh1 = new Animation(0.2f, hit.findRegions("eh1"));
	lh1 = new Animation(0.2f, hit.findRegions("lh1"));
	currentFrame = lh1.getKeyFrame(0);
	enemyATK = true;
}
public void update(){
	
	if(stateTime < 1f){
		stateTime += Gdx.graphics.getDeltaTime();
	}
	else{
		Battlescreen.animatk = false;
		enemyATK = true;
		stateTime = 0f;
	}
	if(enemyATK){
		currentFrame = eh1.getKeyFrame(stateTime);
	}
	else{
		currentFrame = lh1.getKeyFrame(stateTime);
	}
}

public TextureRegion getCurrentFrame() {
	return currentFrame;
}

public void setCurrentFrame(TextureRegion currentFrame) {
	this.currentFrame = currentFrame;
}
}