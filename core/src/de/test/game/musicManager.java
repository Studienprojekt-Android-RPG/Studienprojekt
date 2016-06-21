package de.test.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class musicManager extends Testmap{

	public musicManager() {

	}
	Music demtheme = Gdx.audio.newMusic(Gdx.files.internal("music/Demondus.ogg"));
	Music school = Gdx.audio.newMusic(Gdx.files.internal("music/School.ogg"));
	Music forest = Gdx.audio.newMusic(Gdx.files.internal("music/Forest Gump.ogg"));
	Music home = Gdx.audio.newMusic(Gdx.files.internal("music/LeonsApartment.ogg"));
	Music battle = Gdx.audio.newMusic(Gdx.files.internal("music/Battle Theme.ogg"));
	Music altbau = Gdx.audio.newMusic(Gdx.files.internal("music/Altbau.ogg"));
	Music cave = Gdx.audio.newMusic(Gdx.files.internal("music/Cave of Trials.ogg"));
	Music leon = Gdx.audio.newMusic(Gdx.files.internal("music/Leons Theme.ogg"));
	Music anieres = Gdx.audio.newMusic(Gdx.files.internal("music/Anieres Theme.ogg"));
	public void update() {
		
		switch(super.horst){
			case "go":
				battle.stop();
				break;
		
			case "ev":
				anieres.stop();
				demtheme.stop();
				school.stop();
				forest.stop();
				home.stop();
				battle.stop();
				altbau.stop();
				cave.stop();
				leon.stop();
				switch(super.horsty){
					case "demo":
						anieres.play();
				}
				
				break;
			case "bs":
				anieres.stop();
				cave.stop();
				demtheme.stop();
				forest.stop();
				school.stop();
				altbau.stop();
				battle.play();
				break;
			case "sm":
				anieres.stop();
				demtheme.stop();
				forest.stop();
				school.stop();
				altbau.stop();
				cave.stop();
				leon.play();
				break;
			case"gs":
				anieres.stop();
				leon.stop();
				String map = mapManager.map;
				switch(map){
				
				case "maps/IF2.tmx":
					forest.stop();
					altbau.stop();
					battle.stop();
					school.play();
					break;
				case "maps/altbau.tmx":
					altbau.play();
					battle.stop();
					school.stop();
					break;
				case "maps/cafeteria.tmx":
					battle.stop();
					altbau.stop();
					school.play();
					break;
				case "maps/Dach_Tag.tmx":
					battle.stop();
					school.play();
					break;
				case "maps/Dach_Nacht.tmx":
					battle.stop();
					school.play();
					break;
				case "maps/demondus1.tmx":
						cave.dispose();
						altbau.dispose();
						home.dispose();
						forest.dispose();
						school.dispose();
						battle.stop();
						demtheme.play();
					break;
				case "maps/demondus2.tmx":
						battle.stop();
						demtheme.play();	
					break;
				case "maps/demondus3.tmx":
						battle.stop();
						demtheme.play();
					break;
				case "maps/demondus4.tmx":
						battle.stop();
						demtheme.play();
					break;
				case "maps/demondus5.tmx":
						battle.stop();
						demtheme.play();
					break;
				case "maps/demondus7.tmx":
						battle.stop();
						demtheme.play();
					break;
				case "maps/demondusdorf.tmx":
						battle.stop();
						demtheme.play();	
					break;
				case "maps/Hauptweg_Nacht.tmx":
						school.stop();
						battle.stop();
						home.stop();
						forest.play();
					break;
				case "maps/Hauptweg_Tag.tmx":
						school.stop();
						battle.stop();
						home.stop();
						forest.play();
					break;
				case "maps/ho.tmx":
						school.stop();
						battle.stop();
						forest.stop();
						cave.play();
					break;
				case "maps/kathedrale.tmx":
					battle.stop();
					demtheme.play();
					break;
				case "maps/leonswohnung.tmx":
					cave.stop();
					forest.stop();
					battle.stop();
					home.play();
					break;
				case "maps/Lichtung_Tag.tmx":
					battle.stop();
					forest.play();
					break;
				case "maps/Lichtung_Nacht.tmx":
					battle.stop();
					break;
				case "maps/maze.tmx":
					battle.stop();
					forest.play();
					break;
				case "maps/room.tmx":
					demtheme.play();
					battle.stop();
					break;
				case "maps/See_Nacht.tmx":
					battle.stop();
					forest.play();
					break;
				case "maps/See_Tag.tmx":
					battle.stop();
					forest.play();
					break;
				case "maps/Sozialzweig.tmx":
					battle.stop();
					school.play();
					break;
				case "maps/WegZumSee_Nacht.tmx":
					battle.stop();
					forest.play();
					break;
				case "maps/WegZumSee_Tag.tmx":
					battle.stop();
					forest.play();
					break;
				case "maps/wehhh.tmx":
					battle.stop();
					demtheme.play();
					break;						
				
				}	
				
				break;	

		}
	
	}
		
		
	}
	