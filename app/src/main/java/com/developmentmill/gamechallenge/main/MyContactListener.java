package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;

public class MyContactListener implements ContactListener {

	@Override
	public void beginContact(Contact arg0) {
		processFixture(arg0.getFixtureA());
		processFixture(arg0.getFixtureB());
	}

	@Override
	public void endContact(Contact arg0) {
		// TODO Auto-generated method stub

	}

	private void processFixture(Fixture fixture) {
		Body body = fixture.getBody();
		if (body.getUserData() != null) {
			body.setUserData("Dead");
		}
	}
}
