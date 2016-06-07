package de.test.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Fighter {

	Vector2 position;
	String textureLoc;
	Preferences prefs;
	
	boolean allowMov = true;
	boolean isMoving = false;
	boolean isBattlearea = false;
	private TextureAtlas leon;
	Animation down, left, right, up, standard, f1, f2;
	TextureRegion[] frames;
	TextureRegion currentFrame;
	float stateTime;
	Rectangle bounds;
	String movement;
	float speed = 3f;
	boolean menu = true;
	public Player(Vector2 position, String textureLoc, int atk, int satk, int def, int sdef, int hp, int lvl, int spe, int exp, int sp, int money){
		super(atk, satk, def, sdef, hp, lvl, spe, exp, sp, money);
		prefs = Gdx.app.getPreferences(Gamescreen.saveFile.getName());
		name = "Leon";
		this.position = position;
		movement = "";
		
		leon = new TextureAtlas(Gdx.files.internal("leon.atlas"));
		
		down = new Animation(0.2f, leon.findRegions("down"));
		left = new Animation(0.2f, leon.findRegions("left"));
		right = new Animation(0.2f, leon.findRegions("right"));
		up = new Animation(0.2f, leon.findRegions("up"));
		f1 = new Animation(0.2f, leon.findRegions("f1"));
		
		stateTime = 0f;
		currentFrame = down.getKeyFrame(0);
		bounds = new Rectangle(position.x, position.y,currentFrame.getRegionWidth()-5, currentFrame.getRegionHeight()/2);	
	}
	
	public void update(){
		isMoving = false;
		
		bounds.set(position.x, position.y,currentFrame.getRegionWidth()-5, currentFrame.getRegionHeight()/2);
		
		if(stateTime < 0.8f){
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
		Gamescreen.act.setPosition((this.position.x + 800/2) - 100, (this.position.y - 480/2) + 30);

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
		prefs.putInteger("curHP", curHP);
		prefs.putInteger("maxHP", maxHP);
		prefs.flush();
	}
	
	public void saveBattle(){
		prefs.putInteger("curHP", curHP);
		prefs.putInteger("maxHP", maxHP);
		saveInventory();
		prefs.flush();
	}
	
	public void readPlayer(Player player) throws IOException, ClassNotFoundException{
		player.position.x = prefs.getFloat("player x");
		player.position.y = prefs.getFloat("player y");
		Gamescreen.map = prefs.getString("map");
		mapManager.map = prefs.getString("map");
		curHP = prefs.getInteger("curHP");
		maxHP = prefs.getInteger("maxHP");
	}
	
	public void clearInventorySlots()
	{
		int i = 0;
		for(Slot slot : Gamescreen.game.inventoryscreen.inventoryActor.inv.getSlots())
		{
			prefs.remove("inventorySlot" + i);
			i++;
		}
	}
	
	public void saveInventory()
	{
		int i = 0;
		for (Slot slot : Gamescreen.game.inventoryscreen.inventoryActor.inv.getSlots())
		{
			if(slot.getItem() != null)
			{
				prefs.putString("inventorySlot"+i,slot.toString());
			}
			i++;
		}
	}


	public void readInventory()
	{
		for (int i = 0; i <= 64; i++) 
		{
			if(prefs != null)
			{
				String invSlot = prefs.getString("inventorySlot"+i);
				if(invSlot != "")
				{
					String[] input = invSlot.split(":");
				
					Item item = Item.valueOf(input[0]);						 
					int amount = Integer.parseInt(input[1]);
				
					if(item != null && amount != 0)
					{
						Gamescreen.game.inventoryscreen.inventoryActor.inv.store(item, amount);
					}
				}
			}
		}
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
	
	//Spezialangriffe
	
	public void windschleier(Fighter defender){
		Math.round(this.curHP += this.curHP / 2);
		System.out.println(this.getName() + " heilt sich um "+ Math.round(this.curHP / 2) + " Lebenspunkte!");
	}
	
	public void schockschlag(Fighter defender){
		attackDamage = (this.sATK * this.level * 2) - (defender.sDEF * defender.level / 1.5);
		attackDamage = maxDamage();
		defender.curHP -= attackDamage;
		System.out.println(this.getName() + " fügt durch Schockschlag" + defender.getName() + " " + attackDamage + " Schadenspunkte zu!");
	}
	
}
