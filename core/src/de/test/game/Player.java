package de.test.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Fighter {

	Vector2 position;
	String textureLoc;
	static Preferences prefs = Gdx.app.getPreferences("haw");
	
	int ATK = 9001;
	int sATK;
	int DEF;
	int mDEF;
	int SPD;
	int curPKT;
	int maxPKT;
	int curHP = 20;
	int maxHP = 200;
	int EXP;
	int level;
	
	boolean allowMov = true;
	boolean isMoving = false;
	boolean isBattlearea = false;
	private TextureAtlas leon;
	Animation down, left, right, up;
	Texture playerTexture;
	TextureRegion[] frames;
	TextureRegion currentFrame;
	float stateTime;
	Rectangle bounds;
	String movement;
	float speed = 3f;
	boolean menu = true;
	public Player(Vector2 position, String textureLoc, int atk, int def, int hp, int lvl, int sp, String name){
		super(atk, def, hp, lvl, sp, name);
		this.position = position;
		movement = "";
		
		leon = new TextureAtlas(Gdx.files.internal("leon1.atlas"));
		playerTexture = new Texture(Gdx.files.internal("leon.png"));
		
		down = new Animation(0.2f, leon.findRegions("down"));
		left = new Animation(0.2f, leon.findRegions("left"));
		right = new Animation(0.2f, leon.findRegions("right"));
		up = new Animation(0.2f, leon.findRegions("up"));
		
		stateTime = 0f;
		currentFrame = down.getKeyFrame(0);
		bounds = new Rectangle(position.x, position.y,currentFrame.getRegionWidth()-5, currentFrame.getRegionHeight()/2);	
	}
	
	public void update(){
		isMoving = false;
		
		bounds.set(position.x, position.y,currentFrame.getRegionWidth()-5, currentFrame.getRegionHeight()/2);
		
		if(stateTime < 0.8){
			stateTime += Gdx.graphics.getDeltaTime();
		}
		else{
			stateTime = 0;
		}
		
		if(allowMov == true){
		if(Gamescreen.up.isPressed()){
			position.y += speed;
			movement = "up";
			currentFrame = up.getKeyFrame(stateTime);
			isMoving = true;
		}
		if(Gamescreen.down.isPressed()){
			position.y -= speed;
			movement = "down";
			currentFrame = down.getKeyFrame(stateTime);
			isMoving = true;
		}
		if(Gamescreen.left.isPressed()){
			position.x -= speed;
			movement = "left";
			currentFrame = left.getKeyFrame(stateTime);
			isMoving = true;
		}
		if(Gamescreen.right.isPressed()){
			position.x += speed;
			movement = "right";
			currentFrame = right.getKeyFrame(stateTime);
			isMoving = true;
		}
		
		if(Gdx.input.isKeyPressed(Keys.W)){
			position.y += speed;
			movement = "up";
			currentFrame = up.getKeyFrame(stateTime);
			isMoving = true;
		}
		else if(Gdx.input.isKeyPressed(Keys.S)){
			position.y -= speed;
			movement = "down";
			currentFrame = down.getKeyFrame(stateTime);
			isMoving = true;
		}
		else if(Gdx.input.isKeyPressed(Keys.A)){
			position.x -= speed;
			movement = "left";
			currentFrame = left.getKeyFrame(stateTime);
			isMoving = true;
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
			position.x += speed;
			movement = "right";
			currentFrame = right.getKeyFrame(stateTime);
			isMoving = true;
		}
		else if(Gdx.input.isKeyPressed(Keys.M)){
			if(Gamescreen.gamenu.isVisible() == false){
			Gamescreen.gamenu.setVisible(true);
			Gamescreen.player.allowMov = false;
			}
			else{
				if(Gamescreen.gamenu.isVisible() == true){
				Gamescreen.gamenu.setVisible(false);
				Gamescreen.player.allowMov = true;
				}
			}
		}
		}
		if(Gamescreen.gammenu.isPressed()){
			Gamescreen.gamenu.setVisible(true);
			Gamescreen.player.allowMov = false;
		}
		
		Gamescreen.up.setSize(50, 50);
		Gamescreen.down.setSize(50, 50);
		Gamescreen.left.setSize(50, 50);
		Gamescreen.right.setSize(50, 50);
		Gamescreen.up.setPosition((this.position.x - 800/2) + 90, (this.position.y - 480/2) + 156);
		Gamescreen.down.setPosition((this.position.x - 800/2) + 90, (this.position.y - 480/2) + 36);
		Gamescreen.left.setPosition((this.position.x - 800/2) + 30, (this.position.y - 480/2) + 96);
		Gamescreen.right.setPosition((this.position.x - 800/2) + 150, (this.position.y - 480/2) + 96);
		Gamescreen.gammenu.setPosition((this.position.x + 800/2) - 50, (this.position.y + 480/2) - 50);
		Gamescreen.gamenu.setPosition((this.position.x + 800/2) - 200, (this.position.y + 480/2) - Gamescreen.gamenu.getHeight());
		Gamescreen.warn.setPosition((this.position.x + 800/2) - 150, (this.position.y + 480/2) - 35);
	}
	
	public void reAdjust(){
		if(movement == "up"){
			position.y -= 3f;
		}
		if(movement == "down"){
			position.y += 3f;
		}
		if(movement == "right"){
			position.x -= 3f;
		}
		if(movement == "left"){
			position.x += 3f;
		}
	}
	
	public void savePlayer(Player playerPosition) throws IOException{
		prefs.putFloat("player x", playerPosition.position.x);
		prefs.putFloat("player y",  playerPosition.position.y);
		prefs.putString("map", mapManager.map);
		prefs.flush();
	}
	
	public void readPlayer(Player player) throws IOException, ClassNotFoundException{
		player.position.x = prefs.getFloat("player x");
		player.position.y = prefs.getFloat("player y");
		Gamescreen.map = prefs.getString("map");
		mapManager.map = prefs.getString("map");
		prefs.clear();
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void setPosition(Vector2 position){
		this.position = position;
	}

	public TextureRegion[] getFrames() {
		return frames;
	}

	public void setFrames(TextureRegion[] frames) {
		this.frames = frames;
	}

	public TextureRegion getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(TextureRegion currentFrame) {
		this.currentFrame = currentFrame;
	}

	public float getStateTime() {
		return stateTime;
	}

	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	
	
}
