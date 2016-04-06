package de.test.game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	Vector2 position;
	String textureLoc;
	
	int ATK;
	int sATK;
	int DEF;
	int mDEF;
	int SPD;
	int curPKT;
	int maxPKT;
	int curHP;
	int maxHP;
	int EXP;
	
	boolean allowMov = true;
	private TextureAtlas leon;
	Animation down, left, right, up;
	Texture playerTexture;
	TextureRegion[] frames;
	TextureRegion currentFrame;
	float stateTime;
	Rectangle bounds;
	String movement;
	float speed = 2f;
	boolean menu = true;
	public Player(Vector2 position, String textureLoc){
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
		
		bounds.set(position.x, position.y,currentFrame.getRegionWidth()-5, currentFrame.getRegionHeight()/2);
		
		if(stateTime < 0.8){
			stateTime += Gdx.graphics.getDeltaTime();
		}
		else{
			stateTime = 0;
		}
		
		if(allowMov = true){
		if(Gamescreen.up.isPressed()){
			position.y += speed;
			movement = "up";
			currentFrame = up.getKeyFrame(stateTime);
		}
		if(Gamescreen.down.isPressed()){
			position.y -= speed;
			movement = "down";
			currentFrame = down.getKeyFrame(stateTime);
		}
		if(Gamescreen.left.isPressed()){
			position.x -= speed;
			movement = "left";
			currentFrame = left.getKeyFrame(stateTime);
		}
		if(Gamescreen.right.isPressed()){
			position.x += speed;
			movement = "right";
			currentFrame = right.getKeyFrame(stateTime);
		}
		
		if(Gdx.input.isKeyPressed(Keys.W)){
			position.y += speed;
			movement = "up";
			currentFrame = up.getKeyFrame(stateTime);
		}
		else if(Gdx.input.isKeyPressed(Keys.S)){
			position.y -= speed;
			movement = "down";
			currentFrame = down.getKeyFrame(stateTime);
		}
		else if(Gdx.input.isKeyPressed(Keys.A)){
			position.x -= speed;
			movement = "left";
			currentFrame = left.getKeyFrame(stateTime);
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
			position.x += speed;
			movement = "right";
			currentFrame = right.getKeyFrame(stateTime);
		}
		}
		if(Gamescreen.gammenu.isPressed()){
			Gamescreen.gamenu.setVisible(true);
		}
		
//		Gamescreen.digipad.setPosition((this.position.x - 800/2) + 30, (this.position.y - 480/2) + 50);
		Gamescreen.up.setSize(50, 50);
		Gamescreen.down.setSize(50, 50);
		Gamescreen.left.setSize(50, 50);
		Gamescreen.right.setSize(50, 50);
		Gamescreen.up.setPosition((this.position.x - 800/2) + 90, (this.position.y - 480/2) + 156);
		Gamescreen.down.setPosition((this.position.x - 800/2) + 90, (this.position.y - 480/2) + 36);
		Gamescreen.left.setPosition((this.position.x - 800/2) + 30, (this.position.y - 480/2) + 96);
		Gamescreen.right.setPosition((this.position.x - 800/2) + 150, (this.position.y - 480/2) + 96);
		Gamescreen.touchpad.setBounds((this.position.x - 800/2) + 10, (this.position.y - 480/2) + 30, 200, 200); //(Positionx, Positiony, Größex, Größey)
		Gamescreen.gammenu.setPosition((this.position.x + 800/2) - 50, (this.position.y + 480/2) - 50);
		Gamescreen.gamenu.setPosition((this.position.x + 800/2) - 205, (this.position.y + 480/2) - Gamescreen.gamenu.getHeight());
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
	
	public static void savePlayer(Player playerPosition) throws IOException{
		FileHandle file = Gdx.files.local("Player.dat");
		Player savedPlayer = null;
		OutputStream out = null;
		try{
			file.writeBytes(serialize(playerPosition.getPosition()), false);
		}catch(Exception ex){
			System.out.println(ex.toString());
		}finally{
			if(out != null) try{out.close();} catch(Exception ex){}
		}
		
		System.out.println("Saving Player");
	}
	
	public static Vector2 readPlayer() throws IOException, ClassNotFoundException{
		Vector2 playerPosition = null;
		FileHandle file = Gdx.files.local("Player.dat");
		playerPosition = (Vector2) deserialize(file.readBytes());
		return playerPosition;
	}
	
	@SuppressWarnings("unused")
	private static byte[] serialize(Object obj) throws IOException {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		ObjectOutputStream o = new ObjectOutputStream(b);
		o.writeObject(obj);
		return b.toByteArray();
	}
	
	public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream b = new ByteArrayInputStream(bytes);
		ObjectInputStream o = new ObjectInputStream(b);
		return o.readObject();
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
