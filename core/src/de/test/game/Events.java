package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;


public class Events {
	
	static NPC ani;
	static boolean event = false;
	TextureAtlas butwin;
	Skin skin;
	BitmapFont font;
	WindowStyle ws = new WindowStyle();
	TextButtonStyle buttonstyle = new TextButtonStyle();
	LabelStyle labstyle = new LabelStyle();
	DemoStrings demoStrings;
	public Events(){
		skin = new Skin();
		butwin = new TextureAtlas("butwin.atlas");
		skin.addRegions(butwin);
		font = new BitmapFont(Gdx.files.internal("default.fnt"));
		ws.background = skin.getDrawable("default-window");
		ws.titleFont = font;
		buttonstyle.down = skin.getDrawable("testbutton2");
		buttonstyle.up = skin.getDrawable("testbutton");
		buttonstyle.font = font;
		labstyle.font = font;
		skin.add("default", labstyle);
		skin.add("default", ws);
		skin.add("default", buttonstyle);
		skin.add("dialog", ws);
		skin.add("Button", buttonstyle);
		demoStrings = new DemoStrings(skin);
		demoStrings.setVisible(false);
		demoStrings.setPosition(100, 100);
	}
	
	public void demoEvent(){
		if(ani == null){
			ani = new NPC();
		}
		Testmap.setHorst("ev");
		Testmap.setHorsty("demo");
		Gamescreen.player.allowMov = false;
		event = true;
		ani.movement = "left";
		if(ani.position.x >= Gamescreen.player.position.x + 50){
			ani.position.x -= 3f;
		}
		else{
			ani.movement = "still";
			demoStrings.setVisible(true);
		}
		ani.update();
	}
}
