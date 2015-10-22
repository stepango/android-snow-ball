package com.developmentmill.gamechallenge.main;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;

import com.developmentmill.gamechallenge.Game;

/**
 * Created by IntelliJ IDEA. User: minzdrav Date: 05.01.11 Time: 12:54 To change
 * this template use File | Settings | File Templates.
 */
public class LevelParser {

	private Context mContext;
	private Level level;

	public LevelParser(Level level) {
		mContext = Game.context;
		this.level = level;
	}

	public void parseXMLFromRes(int resId) throws XmlPullParserException,
			IOException {
		Resources res = mContext.getResources();
		XmlResourceParser parser = res.getXml(resId);
		float x, y;
		int type;
		// XmlPullParser parser = Xml.newPullParser();
		// parser.setInput(new StringReader(xml));
		while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
			if (parser.getEventType() == XmlPullParser.START_TAG) {
				String s = parser.getName();
				Log.i("Parce", s);
				if (s.equals("wall")) {
					x = Float.parseFloat(parser.getAttributeValue(null, "x"));
					y = Float.parseFloat(parser.getAttributeValue(null, "y"));
					type = Integer.parseInt(parser.getAttributeValue(null,
							"type"));
					level.addWall(x, y, type);
					Log.i("Ball", "wall");
				} else if (s.equals("ball")) {
					x = Float.parseFloat(parser.getAttributeValue(null, "x"));
					y = Float.parseFloat(parser.getAttributeValue(null, "y"));
					level.addSnowBall(x, y);
					Log.i("Ball", "Ball");
				} else if (s.equals("bomb")) {
					x = Float.parseFloat(parser.getAttributeValue(null, "x"));
					y = Float.parseFloat(parser.getAttributeValue(null, "y"));
					level.addBomb(x, y);
					Log.i("Ball", "bomb");
				} else if (s.equals("target")) {
					x = Float.parseFloat(parser.getAttributeValue(null, "x"));
					y = Float.parseFloat(parser.getAttributeValue(null, "y"));
					level.addTarget(x, y);
					Log.i("Ball", "target");
				}

			}
			parser.next();
		}
	}

	// public String mapToXmlString(Level map) {
	// XmlSerializer serializer = Xml.newSerializer();
	// StringWriter writer = new StringWriter();
	// try {
	// serializer.setOutput(writer);
	// serializer.startDocument("UTF-8", true);
	//
	// serializer.startTag("", "map");
	//
	// serializer.startTag("", "Size");
	// serializer.attribute("", "x", String.valueOf(map.GetSize().x));
	// serializer.attribute("", "y", String.valueOf(map.GetSize().y));
	// serializer.endTag("", "Size");
	//
	// for (int i = 0; i < map.GetSize().x; i++)
	// for (int j = 0; j < map.GetSize().y; j++) {
	// if (map.getObject(new Point(i, j)) != null) {
	// IGameObject something = map.getObject(new Point(i,
	// j));
	//
	// serializer.startTag("", something.getName());
	// serializer.attribute("", "x", String.valueOf(i));
	// serializer.attribute("", "y", String.valueOf(j));
	// serializer.endTag("", something.getName());
	// }
	// }
	// serializer.endTag("", "map");
	// serializer.endDocument();
	//
	// } catch (IllegalArgumentException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IllegalStateException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return writer.toString();
	// }
}
