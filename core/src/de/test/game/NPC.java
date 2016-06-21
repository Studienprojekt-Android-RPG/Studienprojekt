package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class NPC {
	TextureAtlas npc = new TextureAtlas(Gdx.files.internal("anieres.atlas"));
	Animation down = new Animation(0.2f, npc.findRegions("down"));
	Animation left = new Animation(0.2f, npc.findRegions("left"));
	Animation right = new Animation(0.2f, npc.findRegions("right"));
	Animation up = new Animation(0.2f, npc.findRegions("up"));
	Vector2 position = new Vector2(Gamescreen.player.position.x + 500, Gamescreen.player.position.y);
	float stateTime;
	TextureRegion currentFrame = left.getKeyFrame(0);
	String movement;
	
	public void update(){
		if(stateTime < 0.8f){
			stateTime += Gdx.graphics.getDeltaTime();
		}
		else{
			stateTime = 0;
		}
		
		position.y = Gamescreen.player.position.y;
		if(movement.equals("down")){
			currentFrame = down.getKeyFrame(stateTime);
		}
		
		if(movement.equals("left")){
			currentFrame = left.getKeyFrame(stateTime);
		}
		
		if(movement.equals("right")){
			currentFrame = right.getKeyFrame(stateTime);
		}
		
		if(movement.equals("up")){
			currentFrame = up.getKeyFrame(stateTime);
		}
		if(movement.equals("still")){
			currentFrame = left.getKeyFrame(0);
		}
	}
	
	public TextureRegion getCurrentFrame() {
		return currentFrame;
	}
}
