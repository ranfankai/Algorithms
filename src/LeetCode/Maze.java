package LeetCode;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/21.
 */
public class Maze {
    int[][] maze;
    int row,column;
    int endx,endy;
    Maze(int[][] maze,int endx,int endy)
    {
        this.maze = maze;
        row = maze.length;
        column = maze[0].length;
        this.endx = endx;
        this.endy = endy;
    }
    public  boolean exitMaze(int startx, int starty)
    {
        boolean done = false;
        if (startx>-1 && startx<row && starty>-1 && starty<column && maze[startx][starty]==0)
        {
            maze[startx][starty] = 'C'; //走过

            if (startx == endx && starty == endy)done = true;
            else {
                done = exitMaze(startx,starty+1);   //right
                if (!done)
                    done = exitMaze(startx+1,starty);   //down
                if (!done)
                    done = exitMaze(startx,starty-1);   //left
                if (!done)
                    done = exitMaze(startx-1,starty);   //up
            }
            if (done)maze[startx][starty] = 'P';    //正确路径
        }
        return done;
    }
    public static void printmaze(int[][] maze)
    {
        for (int[] a : maze)
            System.out.println(Arrays.toString(a));

    }
    public static void main(String[] args) {
        int[][] maze1 = {{0,0,1,0,0,1,0,0},
                {0,0,1,0,0,1,0,0},
                {0,0,0,0,0,1,0,0},
                {1,1,0,1,1,0,0,0},
                {0,0,0,1,0,0,0,0},
                {0,1,0,1,0,0,1,0},
                {0,1,0,0,0,1,0,0},
                {0,0,1,0,1,0,0,0}};
        Maze mazeins = new Maze(maze1,7,7);

        if (mazeins.exitMaze(0,0)) System.out.println("Successful exit maze!");
        printmaze(maze1);
    }
}
