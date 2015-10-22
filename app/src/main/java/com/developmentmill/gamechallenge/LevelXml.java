package com.developmentmill.gamechallenge;

import java.io.IOException;
import java.io.StringWriter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.developmentmill.gamechallenge.main.Bomb;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Point;
import android.util.Xml;

/**
 * Created by IntelliJ IDEA. User: minzdrav Date: 05.01.11 Time: 12:54 To change
 * this template use File | Settings | File Templates.
 */
public class LevelXml {
	private Context mContext;

	public LevelXml(Context context) {
		mContext = context;
	}

	public Level parseXMLFromRes(int resId)// String xml)
			throws XmlPullParserException, IOException {
		Level result = null;
		Resources res = mContext.getResources();
		XmlResourceParser parser = res.getXml(resId);

		// XmlPullParser parser = Xml.newPullParser();
		// parser.setInput(new StringReader(xml));
		while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
			if (parser.getEventType() == XmlPullParser.START_TAG) {
				String s = parser.getName();
				int x, y;
//				if (s.equals("Size")) {
//					x = Integer.parseInt(parser.getAttributeValue(null, "x"));
//					y = Integer.parseInt(parser.getAttributeValue(null, "y"));
//					result = new Level(new Point(x, y));
//				}
				if (result != null) {
					if (s.equals("wall")) {
						x = Integer.parseInt(parser
								.getAttributeValue(null, "x"));
						y = Integer.parseInt(parser
								.getAttributeValue(null, "y"));
//						result.addObject(new Wall(new Point(x, y)));
//					} else if (s.equals("ball")) {
//						x = Integer.parseInt(parser
//								.getAttributeValue(null, "x"));
//						y = Integer.parseInt(parser
//								.getAttributeValue(null, "y"));
//						result.addObject(new Ball(new Point(x, y)));
					} else if (s.equals("gremlin")) {
						x = Integer.parseInt(parser
								.getAttributeValue(null, "x"));
						y = Integer.parseInt(parser
								.getAttributeValue(null, "y"));
//						result.addObject(new Gremlin(new Point(x, y)));
					}
				}
			}
			parser.next();
		}
		return result;
	}

	public String mapToXmlString(Level map) {
		XmlSerializer serializer = Xml.newSerializer();
		StringWriter writer = new StringWriter();
		try {
			serializer.setOutput(writer);
			serializer.startDocument("UTF-8", true);

			serializer.startTag("", "map");

			serializer.startTag("", "Size");
			serializer.attribute("", "x", String.valueOf(map.GetSize().x));
			serializer.attribute("", "y", String.valueOf(map.GetSize().y));
			serializer.endTag("", "Size");

			for (int i = 0; i < map.GetSize().x; i++)
				for (int j = 0; j < map.GetSize().y; j++) {
					if (map.getObject(new Point(i, j)) != null) {
						IGameObject something = map.getObject(new Point(i,
								j));

						serializer.startTag("", something.getName());
						serializer.attribute("", "x", String.valueOf(i));
						serializer.attribute("", "y", String.valueOf(j));
						serializer.endTag("", something.getName());
					}
				}
			serializer.endTag("", "map");
			serializer.endDocument();

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer.toString();
	}
}
