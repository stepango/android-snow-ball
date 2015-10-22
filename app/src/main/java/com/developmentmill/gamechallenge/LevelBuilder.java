package com.developmentmill.gamechallenge;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;

public class LevelBuilder {
	public Level getLevelFromRes(int id, Context context) {
		LevelXml levelXml = new LevelXml(context);
		try {
			Level level = levelXml.parseXMLFromRes(id);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
