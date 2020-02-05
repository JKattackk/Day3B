package com.company;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Main {

    public static void main(String[] args) throws Exception
    {
            File file = new File("C:\\Users\\Jack\\Desktop\\ADVENT OF CODE\\DAY3\\input.txt");
            Scanner sc = new Scanner(file);
            int count = 0;
            while(sc.hasNextLine())
            {
                count++;
                System.out.println(sc.nextLine());
            }
            sc = new Scanner(file);
            String[][] paths = new String[count][];
            Grid[] grids = new Grid[count];
        for(int i = 0; i < count; i++)
        {
            paths[i]= sc.nextLine().split(",");
            grids[i] = new Grid(paths[i]);
            for(int x = 0; x < paths[i].length; x++)
            {
                grids[i].move(paths[i][x].charAt(0), Integer.parseInt(paths[i][x].substring(1)));
            }
        }
        System.out.println("_______");
        int min = MAX_VALUE;
        HashMap<Integer, Point> ints = grids[0].findIntersections(grids[1]);
        for(int i = 0; i < ints.size(); i++)
        {
            int steps = grids[0].findMinSteps(ints.get(i)) + grids[1].findMinSteps(ints.get(i));
            if(steps <= min)
            {
                min = steps;
            }
        }
        System.out.println(min);
    }
}
