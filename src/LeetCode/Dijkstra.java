package LeetCode;

import java.util.Arrays;

/**
 * Created by haha on 2018/7/23.
 */
public class Dijkstra {


    public static void dijkstra(int[][] map, int v0)
    {
        int N = map.length;
        int[] paths = new int[N];
        int[] dists = map[v0];
        int[] S = new int[N];

        for (int i=0; i<N; i++ )
        {
            S[i] = 0;
            dists[i] = map[v0][i];
            if (dists[i]<Integer.MAX_VALUE)paths[i] = v0;
            else paths[i] = -1;
        }
        S[v0] = 1;

        for (int i = 1; i < N-1; i++)
        {
            int v = -1;
            int min = Integer.MAX_VALUE;
            for (int w=0; w<N; w++)
            {
                if (S[w]!=1 && dists[w]<min)
                {
                    v = w;
                    min = dists[w];
                }
            }
            if (v == -1)break;

            S[v] = 1;
            for (int j=0;j<N;j++)
            {

                int newdist = min+map[v][j];
                if (newdist < 0)continue;
//                if (newdist > Integer.MAX_VALUE)continue;
                if (S[j]==0 && dists[j]>newdist)
                {
                    dists[j] = (int)newdist;
                    paths[j] = v;
                }
            }
        }
        System.out.println(Arrays.toString(paths));
    }
    public static void main(String[] args) {
        final int MAXINT = Integer.MAX_VALUE;
        int[][] map = {{0,MAXINT,10,MAXINT,30,100},
                {MAXINT,0,5,MAXINT,MAXINT,MAXINT},
                {MAXINT,MAXINT,0,50,MAXINT,MAXINT},
                {MAXINT,MAXINT,MAXINT,0,MAXINT,10},
                {MAXINT,MAXINT,MAXINT,20,0,60},
                {MAXINT,MAXINT,MAXINT,MAXINT,MAXINT,0}};
        dijkstra(map,0);
        //char[] a = {'l',''}
    }
}
