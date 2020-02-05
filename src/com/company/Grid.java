package com.company;

import java.util.HashMap;

public class Grid {
    private boolean[][] grid;
    private int x;
    private int y;
    private String[] path;

    public Grid(String[] p) {
        path = p;
        grid = new boolean[20001][20001];
        x = 5000;
        y = 5000;
    }

    private boolean value(int x, int y) {
        return grid[x][y];
    }

    public void move(char direction, int magnitude) {
        for (int i = 0; i < magnitude; i++) {
            if (direction == "U".charAt(0)) {
                y++;
                grid[x][y] = true;
            } else if (direction == "D".charAt(0)) {
                y--;
                grid[x][y] = true;
            } else if (direction == "R".charAt(0)) {
                x++;
                grid[x][y] = true;
            } else if (direction == "L".charAt(0)) {
                x--;
                grid[x][y] = true;
            }
        }
    }

    public HashMap<Integer, Point> findIntersections(Grid grid2) {
        int count = 0;
        HashMap<Integer, Point> list = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int z = 0; z < grid[i].length; z++) {
                if (grid[i][z] && grid2.value(i, z)) {
                    list.put(count, new Point(i, z));
                    count++;
                }
            }
        }
        return list;
    }

    public int findMinSteps(Point point) {
        int xtemp = 5000;
        int ytemp = 5000;
        int count = 0;

        for (int x = 0; x < path.length; x++) {
            char dir = path[x].charAt(0);
            int mag = Integer.parseInt(path[x].substring(1));
            for (int i = 0; i < mag; i++) {
                if (dir == "U".charAt(0)) {
                    ytemp++;
                    count++;
                    if(ytemp == point.gety() && xtemp == point.getx())
                    {
                        return count;
                    }
                } else if (dir == "D".charAt(0)) {
                    ytemp--;
                    count++;
                    if(ytemp == point.gety() && xtemp == point.getx())
                    {
                        return count;
                    }
                } else if (dir == "R".charAt(0)) {
                    xtemp++;
                    count++;
                    if(ytemp == point.gety() && xtemp == point.getx())
                    {
                        return count;
                    }
                } else if (dir == "L".charAt(0)) {
                    xtemp--;
                    count++;
                    if(ytemp == point.gety() && xtemp == point.getx())
                    {
                        return count;
                    }
                }
            }
        }
        return 0;
    }
}
