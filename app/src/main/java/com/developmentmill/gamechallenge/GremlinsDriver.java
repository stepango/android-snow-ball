package com.developmentmill.gamechallenge;

import java.util.ArrayList;

import android.graphics.Point;

/**
 * Created by IntelliJ IDEA.
 * User: minzdrav
 * Date: 05.01.11
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
public class GremlinsDriver {

	private Level mMap;

    public GremlinsDriver(Level map) {
        mMap = map;
    }

    public void moveAll() {
        Point size = mMap.GetSize();
        for (IGameObject gremlin : mMap.getGremlins()) {
            ArrayList<Point> path =
                    Pathfinder.getPath(mMap.getAllObjects(), size, gremlin.getCoordinate(),
                            new Point(size.x - 1, size.y - 1), size.x * size.y);
            //TODO: move this object!!!
        }
    }
}
