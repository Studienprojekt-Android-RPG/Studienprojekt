package de.test.game;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Fighter {

	static Testmap game;
	
	Vector2 position;
	String textureLoc;	
	
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
	float rspeed = 3f;
	boolean menu = true;
	
	int expBucket = 0;
	
	int nextLv= 1000; 
	Random random = new Random();
	
	public Player(Vector2 position, String textureLoc/*, int atk, int satk, int def, int sdef, int hp, int lvl, int spe, int exp, int sp, int money*/){
//		super(atk, satk, def, sdef, hp, lvl, spe, exp, sp, money);
//		super(10, 7, 7, 7, 100, 1, 10, 0, 0, 50);				//for new character
		super(55, 55, 10, 10, 7000, 20, 10, 600, 10, 500, null, null, null);		//for Demo
		
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
			position.y += rspeed;
			movement = "up";
			currentFrame = up.getKeyFrame(stateTime);
			isMoving = true;
		}
		if(Gamescreen.down.isPressed()){
			position.y -= rspeed;
			movement = "down";
			currentFrame = down.getKeyFrame(stateTime);
			isMoving = true;
		}
		if(Gamescreen.left.isPressed()){
			position.x -= rspeed;
			movement = "left";
			currentFrame = left.getKeyFrame(stateTime);
			isMoving = true;
		}
		if(Gamescreen.right.isPressed()){
			position.x += rspeed;
			movement = "right";
			currentFrame = right.getKeyFrame(stateTime);
			isMoving = true;
		}
		
		if(Gdx.input.isKeyPressed(Keys.W)){
			position.y += rspeed;
			movement = "up";
			currentFrame = up.getKeyFrame(stateTime);
			isMoving = true;
		}
		else if(Gdx.input.isKeyPressed(Keys.S)){
			position.y -= rspeed;
			movement = "down";
			currentFrame = down.getKeyFrame(stateTime);
			isMoving = true;
		}
		else if(Gdx.input.isKeyPressed(Keys.A)){
			position.x -= rspeed;
			movement = "left";
			currentFrame = left.getKeyFrame(stateTime);
			isMoving = true;
		}
		else if(Gdx.input.isKeyPressed(Keys.D)){
			position.x += rspeed;
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
		Testmap.prefs.putFloat("player x", playerPosition.position.x);
		Testmap.prefs.putFloat("player y",  playerPosition.position.y);
		Testmap.prefs.putString("map", mapManager.map);
		Testmap.prefs.putInteger("curHP", curHP);
		Testmap.prefs.putInteger("maxHP", maxHP);
		Testmap.prefs.putInteger("EXP", EXP);
		Testmap.prefs.putInteger("Level", level);
		Testmap.prefs.putInteger("ATK", ATK);
		Testmap.prefs.putInteger("DEF", DEF);
		Testmap.prefs.putInteger("sATK", sATK);
		Testmap.prefs.putInteger("sDEF", sDEF);
		Testmap.prefs.putInteger("speed", speed);
		Testmap.prefs.putInteger("curSP", curSP);
		Testmap.prefs.putInteger("maxSP", maxSP);
		Testmap.prefs.putInteger("nextLv", nextLv);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		Testmap.prefs.putString("saveTime", sdf.format(c.getTime()));
		Testmap.prefs.flush();
	}
	
	public void saveBattle(){
		Testmap.prefs.putInteger("curHP", curHP);
		Testmap.prefs.putInteger("maxHP", maxHP);
		Testmap.prefs.putInteger("EXP", EXP);
		Testmap.prefs.putInteger("Level", level);
		Testmap.prefs.putInteger("ATK", ATK);
		Testmap.prefs.putInteger("DEF", DEF);
		Testmap.prefs.putInteger("sATK", sATK);
		Testmap.prefs.putInteger("sDEF", sDEF);
		Testmap.prefs.putInteger("speed", speed);
		Testmap.prefs.putInteger("curSP", curSP);
		Testmap.prefs.putInteger("maxSP", maxSP);
		Testmap.prefs.putInteger("nextLv", nextLv);
		Testmap.prefs.flush();
	}
	
	public void readBattle(){
		ATK = Testmap.prefs.getInteger("ATK");
		DEF = Testmap.prefs.getInteger("DEF");
		sATK = Testmap.prefs.getInteger("sATK");
		sDEF = Testmap.prefs.getInteger("sDEF");
		speed = Testmap.prefs.getInteger("speed");
		nextLv = Testmap.prefs.getInteger("nextLv");
	}
	
	public void readPlayer() {
		if(Testmap.prefs.getString("map")!="")
		{
			position.x = Testmap.prefs.getFloat("player x");
			position.y = Testmap.prefs.getFloat("player y");
			Gamescreen.map = Testmap.prefs.getString("map");
			mapManager.map = Testmap.prefs.getString("map");
			curHP = Testmap.prefs.getInteger("curHP");
			maxHP = Testmap.prefs.getInteger("maxHP");
			EXP = Testmap.prefs.getInteger("EXP");
			ATK = Testmap.prefs.getInteger("ATK");
			DEF = Testmap.prefs.getInteger("DEF");
			sATK = Testmap.prefs.getInteger("sATK");
			sDEF = Testmap.prefs.getInteger("sDEF");
			speed = Testmap.prefs.getInteger("speed");
			level = Testmap.prefs.getInteger("Level");
			curSP = Testmap.prefs.getInteger("curSP");
			maxSP = Testmap.prefs.getInteger("maxSP");
			nextLv = Testmap.prefs.getInteger("nextLv");
		}
	}
	
	public void clearInventorySlots()
	{
		int i = 0;
		for(Slot slot : InventoryScreen.inventoryActor.inv.getSlots())
		{
			Testmap.prefs.remove("inventorySlot" + i);
			i++;
		}
	}
	
	public void clearEquipmentSlots() {
		int i = 0;
		for(Slot slot : Gamescreen.game.inventoryscreen.equipment.equip.getSlots()) {
			Testmap.prefs.remove("equipmentSlot" + i);
			i++;
		}
	}
	public void saveInventory()
	{
		int i = 0;
		for (Slot slot : InventoryScreen.inventoryActor.inv.getSlots())
		{
			if(slot.getItem() != null)
			{
				Testmap.prefs.putString("inventorySlot"+i,slot.toString());
			}
			i++;
		}
	}

	public void saveEquipment() {
		int i = 0;
		for(Slot slot : InventoryScreen.equipment.equip.getSlots()) {
			if(slot.getItem() != null) {
				Testmap.prefs.putString("equipmentSlot" + i, slot.toString());
			}
			i++;
		}
	}

	public static void readInventory()
	{
		for (int i = 0; i <= 64; i++) 
		{
			if(Testmap.prefs != null)
			{
				String invSlot = Testmap.prefs.getString("inventorySlot"+i);
				if(invSlot != "")
				{
					String[] input = invSlot.split(":");
				
					Item item = Item.valueOf(input[0]);						 
					int amount = Integer.parseInt(input[1]);
				
					if(item != null && amount != 0)
					{
						InventoryScreen.inventoryActor.inv.store(item, amount);
					}
				}
			}
		}
	}
	
	public static void readEquipment()
	{
		for (int i = 0; i <= 5; i++) 
		{
			if(Testmap.prefs != null)
			{
				String invSlot = Testmap.prefs.getString("equipmentSlot"+i);
				if(invSlot != "")
				{
					String[] input = invSlot.split(":");
				
					Item item = Item.valueOf(input[0]);						 
					int amount = Integer.parseInt(input[1]);
				
					if(item != null && amount != 0)
					{
						InventoryScreen.equipment.equip.equip(item, amount);
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
	
	//Level-Up Funktionen
	public void levelSum(){
		
		if(this.level < 30){
			this.EXP += this.expBucket;
						
			if(this.EXP >= this.nextLv){
				this.levelUp();
				
				if(this.level != 30){
					this.nextLv += (int) this.nextLv*1.5;
				}
			}			
		}
			
	}
	
	public void levelUp(){
		
		level += 1;
		ATK += (int)(Math.random() * 4 + 3);
		DEF += (int)(Math.random() * 4 + 3);
		sATK += (int)(Math.random() * 4 + 3);
		sDEF += (int)(Math.random() * 4 + 3);
		speed += (int)(Math.random() * 4 + 3);
		maxHP += (int)(Math.random() * 100 + 150);
		maxSP += (int)(Math.random() * 10 + 10);
		curHP = maxHP;
		curSP = maxSP;
		
		if(this.ATK >= 255)
		{
			this.ATK = 255;
		}
		if(this.DEF >= 255)
		{
			this.DEF = 255;
		}
		
		if(this.sATK >= 255)
		{
			this.sATK = 255;
		}
		
		if(this.sDEF >= 255)
		{
			this.sDEF = 255;
		}
		
		if(this.speed >= 255)
		{
			this.speed = 255;
		}
		
		if(this.maxHP >= 9999)
		{
			this.maxHP = 9999;
		}
		if(this.maxSP >= 999)
		{
			this.maxSP = 999;
		}
	}
	
	public void increaseBucket(int exp){
		
		this.expBucket += exp;
		
	}
	
	/**
	 * Checks {@code Equipment} for equipped items to change stats influenced by items.
	 */
	public void equippedItems() {
		for(Slot slot : InventoryScreen.equipment.equip.getSlots()) {
			if(slot.getItem() != null) {
				ATK += slot.getItem().getAtk();
				DEF += slot.getItem().getDef();
				maxHP += slot.getItem().getHP();
				maxSP += slot.getItem().getSP();
				speed += slot.getItem().getSpeed();
			}
		}
		saveBattle();
	}
	
	/**
	 * Decreases stats of player when item is unequipped
	 * @param item
	 */
	public void unequipItem(Item item) {
		if(item != null) {
			ATK -= item.getAtk();
			DEF -= item.getDef();
			maxHP -= item.getHP();
			maxSP -= item.getSP();
			speed -= item.getSpeed();
		}
	}
}
