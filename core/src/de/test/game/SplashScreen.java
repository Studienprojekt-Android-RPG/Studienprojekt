package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SplashScreen implements Screen {

	private float minimumShowTime = 3.0f;

	private OrthographicCamera camera;

	private Viewport viewport;

	private Texture splash;

	@Override
	public void show() {
		LibgdxUtils.assets.load("splash.png", Texture.class);
		LibgdxUtils.assets.finishLoading();
		splash = LibgdxUtils.assets.get("splash.png", Texture.class);

		LibgdxUtils.assets.load("uiskin.json", Skin.class);
		LibgdxUtils.assets.load("icons.atlas", TextureAtlas.class);

		camera = new OrthographicCamera();
		viewport = new FitViewport(splash.getWidth(), splash.getHeight(), camera);
	}

	@Override
	public void resume() {
		LibgdxUtils.assets.finishLoading();
	}

	@Override
	public void render(float deltaTime) {
		if (LibgdxUtils.assets.update() && minimumShowTime <= 0) {
			LibgdxUtils.game.setScreen(new InventoryScreen(null));
		}

		Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		LibgdxUtils.spriteBatch.setProjectionMatrix(camera.combined);
		LibgdxUtils.spriteBatch.begin();
		LibgdxUtils.spriteBatch.draw(splash, 0, 0);
		LibgdxUtils.spriteBatch.end();

		minimumShowTime -= deltaTime;
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void pause() {
		// NOOP
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
	}

}