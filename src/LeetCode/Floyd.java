package LeetCode;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/24.
 */
public class Floyd {
    public static void floyd(int[][] map)
    {
        final int NUM = map.length;
        int[][] cost = map;
        int[][] path = new int[NUM][NUM];
        for (int i=0;i<NUM;i++)
        {
            for (int j=0;j<NUM;j++)
            {
                if (i==j || cost[i][j]==Integer.MAX_VALUE)
                    path[i][j] = -1;
                else path[i][j] = i;
            }
        }

        for (int k=0;k<NUM;k++)
            for (int i=0;i<NUM;i++)
                for (int j = 0; j < NUM; j++) {
                    int sum = map[k][j] + map[i][k];
                    if (sum>0 && sum < map[i][j])
                    {
                        map[i][j] = sum;
                        path[i][j] = path[k][j];
                    }
                }


       // for (int[] a : path) System.out.println(Arrays.toString(a));
        for (int[] a : map) System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[][] map = {{0,1,max,4},
                        {max,0,9,2},
                        {3,5,0,8},
                        {max,max,6,0}};
        floyd(map);

    }
}
