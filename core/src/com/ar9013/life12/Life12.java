package com.ar9013.life12;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Life12 extends ApplicationAdapter {
	SpriteBatch batch;
	Pixmap pixmap;
	Texture texture;
	Sprite sprite;

	
	@Override
	public void create () {
		batch = new SpriteBatch();

		pixmap = new Pixmap(256,128, Pixmap.Format.RGB888);

		pixmap.setColor(Color.RED);
		pixmap.fill();

		// 劃線
		pixmap.setColor(Color.BLACK);
		pixmap.drawLine(0,0,pixmap.getWidth()-1,pixmap.getHeight()-1);
		pixmap.drawLine(0,pixmap.getHeight()-1,pixmap.getWidth()-1,0);

		//畫圓
		pixmap.setColor(Color.YELLOW);
		pixmap.drawCircle(pixmap.getWidth()/2,pixmap.getHeight()/2,pixmap.getHeight()/2-1);

		texture = new Texture(pixmap);

		pixmap.dispose();
		sprite = new Sprite(texture);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.setPosition(0, 0);
		sprite.draw(batch);
		sprite.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		texture.dispose();
	}
}
