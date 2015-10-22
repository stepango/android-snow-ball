package com.developmentmill.gamechallenge;

import android.graphics.Point;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.developmentmill.gamechallenge.main.Bomb;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: minzdrav
 * Date: 05.01.11
 * Time: 11:48
 * To change this template use File | Settings | File Templates.
 */
public class Level extends Stage{
	
	public static final String GREMLINS_GROUP_NAME = "gremlins";
	public static final String BALLS_GROUP_NAME = "balls";
	public static final String BONUSES_GROUP_NAME = "bonuses";
	
	private Group ballsGroup = new Group(BALLS_GROUP_NAME);
	private Group gremlinsGroup = new Group(GREMLINS_GROUP_NAME);
	private Group bonusesGroup = new Group(BONUSES_GROUP_NAME);
	
//	public Group getGremlinsGroup() {
//		return gremlinsGroup;
//	}
//	
//	public Group getBallsGroup() {
//		return ballsGroup;
//	}
//
//	public Group getBonusesGroup() {
//		return bonusesGroup;
//	}
	
	public void addGremlin(Bomb gremlin){
		
	}

	public Level(float width, float height, boolean scratchToRealDeviceResolution) {
		super(width, height, scratchToRealDeviceResolution);
	}

	private IGameObject[][] mObjects;
    private ArrayList<IGameObject> mGremlins;
    private Point mSize;

//    public Level(Point size) {
//        mSize = size;
//        mObjects = new IGameObject[size.x][size.y];
//        mGremlins = new ArrayList<IGameObject>();
//    }

    public Point GetSize() {
        return mSize;
    }

//    public boolean addObject(IGameObject object) {
//        Point point = object.getCoordinate();
//        if ((point.x < mSize.x) && (point.x >= 0) &&
//                (point.y < mSize.y) && (point.y >= 0)) {
//            mObjects[point.x][point.y] = object;
//            if (object.getClass() == Bomb.class)
//                mGremlins.add(object);
//            return true;
//        } else
//            return false;
//    }

    public IGameObject getObject(Point point) {
        if ((point.x < mSize.x) && (point.x >= 0) &&
                (point.y < mSize.y) && (point.y >= 0)) {
            return mObjects[point.x][point.y];
        } else
            return null;
    }

    public IGameObject[][] getAllObjects() {
        return mObjects.clone();
    }

    public boolean moveObject(Point from, Point to) {
        if ((from.x < mSize.x) && (from.x >= 0) &&
                (from.y < mSize.y) && (from.y >= 0)) {
            if ((to.x < mSize.x) && (to.x >= 0) &&
                    (to.y < mSize.y) && (to.y >= 0)) {
                if (mObjects[from.x][from.y] != null
                        && mObjects[to.x][to.y] == null) {
                    IGameObject object = mObjects[from.x][from.y];
                    mObjects[from.x][from.y] = null;
                    mObjects[to.x][to.y] = object;
                    object.setCoordinate(to);
                    return true;
                }
            }
        }
        return false;
    }

//    public void removeObject(Point point) {
//        if (mObjects[point.x][point.y].getClass() == Bomb.class)
//            mGremlins.remove(mObjects[point.x][point.y]);
//        mObjects[point.x][point.y] = null;
//    }

    public ArrayList<IGameObject> getGremlins() {
        return mGremlins;
    }
}
