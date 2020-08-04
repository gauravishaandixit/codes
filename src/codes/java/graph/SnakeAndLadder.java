package codes.java.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    class Entry
    {
        int v;
        int dis;
        Entry()
        {

        }
        Entry(int v, int dis)
        {
            this.v = v;
            this.dis = dis;
        }
    }
    int snakesAndLadders(int[][] board) {

        int n=board.length;
        int arr[] = new int [n*n+1];
        int c=1;
        boolean dir=true;
        for(int i=n-1;i>=0;i--)
        {
            if(dir)
            {
                for(int j=0;j<n;j++)
                {
                    arr[c++]=board[i][j];
                }
            }
            else
            {
                for(int j=n-1;j>=0;j--)
                {
                    arr[c++]=board[i][j];
                }
            }
            dir =! dir;
        }

        if(arr[n*n]!=-1)
            return -1;

        int vis[]=new int[n*n+1];
        Queue<Entry> q=new LinkedList<>();
        Entry e=new Entry();
        e.v=1;
        e.dis=0;
        vis[0]=1;

        q.add(e);

        while(!q.isEmpty())
        {
            e=q.poll();
            int v=e.v;

            if(v==(n*n))
                return e.dis;

            for(int j=v+1;j<=v+6 && j<(n*n+1);j++)
            {
                if(vis[j]==0)
                {
                    Entry new_e = new Entry();
                    new_e.dis=e.dis+1;
                    vis[j]=1;

                    if(arr[j]!=-1)
                        new_e.v=arr[j];
                    else
                        new_e.v=j;

                    q.add(new_e);
                }
            }
        }
        return -1;
    }

    int snakesAndLadders(int[][] snla, int n)
    {
        int[] arr = new int[n * n + 1];
        Arrays.fill(arr, -1);
        for(int[] snl: snla)
            arr[snl[0]] = snl[1];

        boolean[] vis = new boolean[n * n + 1];
        Queue<Entry> q = new LinkedList<>();
        q.add(new Entry(1, 0));
        vis[1] = true;
        Entry en;

        while(!q.isEmpty())
        {
            en = q.poll();
            int currPos = en.v;

            if(currPos == n*n)
                return en.dis;

            for(int nextPos = currPos + 1; nextPos <= currPos + 6 && nextPos <= (n * n); nextPos++)
            {
                if(!vis[nextPos])
                {
                    vis[nextPos] = true;
                    if(arr[nextPos] != -1)
                        q.add(new Entry(arr[nextPos], en.dis + 1));
                    else
                        q.add(new Entry(nextPos, en.dis + 1));
                }
            }
        }
        return -1;
    }

}
