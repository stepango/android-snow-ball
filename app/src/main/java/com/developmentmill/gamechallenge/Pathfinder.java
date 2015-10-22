package com.developmentmill.gamechallenge;

import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: minzdrav
 * Date: 05.01.11
 * Time: 11:54
 * To change this template use File | Settings | File Templates.
 */
public class Pathfinder {
	public static ArrayList<Point> getPath(IGameObject[][] objects,
			Point size, Point fromCoordinate,
			Point toCoordinate, int nmax) {
		int[][] pathMap = new int[size.x][size.y];
		ArrayList<Point> onTable = new ArrayList<Point>();
		ArrayList<Point> path = new ArrayList<Point>();

		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 9; j++){
				if (objects[i][j] != null){
					onTable.add(new Point(i, j));
				}
			}

		for (int i = 0; i < size.x; i++) {
			for (int j = 0; j < size.y; j++) {
				Point thisCoordinate = new Point(i, j);
				if (onTable.equals(thisCoordinate))
					pathMap[i][j] = -2; // �� ���������
				else
					pathMap[i][j] = -1; // ���������
				if (thisCoordinate.equals(fromCoordinate))
					pathMap[i][j] = -3; // ����� �����������
				if (thisCoordinate.equals(toCoordinate))
					pathMap[i][j] = 0; // ����� ����������
			}
		}
		boolean end = false;
		int lastn = 0;
		for (int n = 0; n < nmax; n++) {
			for (int i = 0; i < size.x; i++) {
				for (int j = 0; j < size.y; j++) {
					if (pathMap[i][j] == n) {
						if (((i - 1 >= 0) && (pathMap[i - 1][j] == -3))
								|| ((i + 1 < size.x) && (pathMap[i + 1][j] == -3))
								|| ((j - 1 >= 0) && (pathMap[i][j - 1] == -3))
								|| ((j + 1 < size.y) && (pathMap[i][j + 1] == -3))) {
							end = true;
							lastn = n;
							break;
						}
						if ((i - 1 >= 0) && (pathMap[i - 1][j] == -1)) {
							pathMap[i - 1][j] = n + 1;
						}
						if ((i + 1 < size.x) && (pathMap[i + 1][j] == -1)) {
							pathMap[i + 1][j] = n + 1;
						}
						if ((j - 1 >= 0) && (pathMap[i][j - 1] == -1)) {
							pathMap[i][j - 1] = n + 1;
						}
						if ((j + 1 < size.y) && (pathMap[i][j + 1] == -1)) {
							pathMap[i][j + 1] = n + 1;
						}
					}
				}
				if (end)
					break;
			}
			if (end)
				break;
		}
		if (end) {
			path.add(fromCoordinate);
			Point selected = new Point(fromCoordinate.x,
					fromCoordinate.y);
			while (true) {
				if ((selected.x - 1 >= 0)
						&& (pathMap[selected.x - 1][selected.y] == lastn)) {
					path.add(new Point(selected.x - 1, selected.y));
					selected.x--;
				} else if ((selected.x + 1 < size.x)
						&& (pathMap[selected.x + 1][selected.y] == lastn)) {
					path.add(new Point(selected.x + 1, selected.y));
					selected.x++;
				} else if ((selected.y - 1 >= 0)
						&& (pathMap[selected.x][selected.y - 1] == lastn)) {
					path.add(new Point(selected.x, selected.y - 1));
					selected.y--;
				} else if ((selected.y + 1 < size.y)
						&& (pathMap[selected.x][selected.y + 1] == lastn)) {
					path.add(new Point(selected.x, selected.y + 1));
					selected.y++;
				}
				lastn--;
				if (lastn < 0)
					break;
			}
		}
		return path;
	}
}
