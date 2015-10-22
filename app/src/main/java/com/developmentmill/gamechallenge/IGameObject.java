package com.developmentmill.gamechallenge;

import android.graphics.Point;

/**
 * Created by IntelliJ IDEA.
 * User: minzdrav
 * Date: 05.01.11
 * Time: 11:50
 * To change this template use File | Settings | File Templates.
 */
public interface IGameObject {
    public String getName();
    public Point getCoordinate();
    public void setCoordinate(Point point);
}
