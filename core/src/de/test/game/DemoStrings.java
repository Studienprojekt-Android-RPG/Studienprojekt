package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

public class DemoStrings extends Window{
	
	String[] strings = new String[11];
	Label label;
	TextButton next;
//	Texture avatar;
	Image avatar = new Image();
	ScrollPane scroll;
	Table text = new Table();
	int index = 0;
	TextureAtlas avatare;
	Skin draw = new Skin();
	boolean end = false;
	
	public DemoStrings(final Skin skin) {
		super("", skin);
		
		strings[0] = "Verhülltes Mädchen: \nIch habe dich schon erwartet, Leon.";
		strings[1] = "Leon: \nWer bist du? Gehörst du zu Iuvemis?";
		strings[2] = "Verhülltes Mädchen: \nNein. Aber ich komme aus derselben Welt wie er. Mein Name ist Anieres.";
		strings[3] = "Leon: \nDann willst du nicht gegen mich kämpfen?";
		strings[4] = "Anieres: \nNicht jeder von uns ist euch gegenüber feindselig. Ich bin gekommen, um dir zu helfen.";
		strings[5] = "Leon: \nDennoch - ich verstehe nicht, was das alles soll. Warum passiert das alles?";
		strings[6] = "Anieres: \nWas mit euch geschieht, tut mir leid. Aber weder ich, noch die die mir beistehen, können etwas dagegen tun.";
		strings[7] = "Leon: \nWas passiert mit den Verschwundenen?";
		strings[8] = "Anieres: \nSie werden für unsere Welt benutzt. Ein einst glanzvolles Reich, jetzt nur noch ein Schatten dessen, was es vor langer Zeit war.";
		strings[9] = "Leon: \nIch kapier das nicht. Das ergibt doch gar keinen Sinn.";
		strings[10] = "Anieres: \nGeh den Gang hinunter. Dort wirst du auf Iuvemis treffen. Später werde ich dir deine Fragen beantworten. Doch bevor du gehst, möchte ich dir etwas geben, was dir helfen wird, gegen ihn zu bestehen. Triff eine kluge Wahl.";
		
		next = new TextButton("Weiter", skin, "Button");
		label = new Label(strings[index], skin);
		label.setWrap(true);
		avatare = new TextureAtlas("avatare.atlas");
		draw.addRegions(avatare);
	    avatar.setDrawable(draw.getDrawable("AnieresAvatar"));
	    avatar.setSize(100, 100);

		scroll = new ScrollPane(text);
		text.add(label).width(700).padBottom(10).align(Align.center);

		this.add(avatar).width(100).height(100).padBottom(10).padTop(5).align(Align.center);
		this.add(scroll);
		this.row();
		
		this.add();
		this.add(next).padBottom(10).align(Align.bottomRight);
		this.pack();
		this.setSize(920, 200);
		
		next.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				if(index == 10){
					Events.end = true;
				}
				if(index+1 < strings.length){
					index++;
					if(avatar.getDrawable().equals(draw.getDrawable("AnieresAvatar"))){
						avatar.setDrawable(draw.getDrawable("LeonAvatar"));
					}
					else{
						avatar.setDrawable(draw.getDrawable("AnieresAvatar"));
					}
				}
				
				label.setText(strings[index]);
				
	        }
	    });
	}
	
}
