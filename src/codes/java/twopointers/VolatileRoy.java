package codes.java.twopointers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class VolatileRoy {
    private static HashMap<Integer, Integer> getAllShortestPath() {
        HashMap<Integer, Integer> shortestPath = new HashMap<>();
        int start=123456789;
        int[][] swap={{0,1},{1,2},{3,4},{4,5},{6,7},{7,8},{0,3},{1,4},{2,5},{3,6},{4,7},{5,8}};
        shortestPath.put(start,0);
        Deque<Integer> q = new ArrayDeque<>();
        int[] pow = new int[9];
        pow[pow.length-1]=1;
        for(int i=pow.length-2; i>-1; i--)
            pow[i]=10*pow[i+1];
        q.offer(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int[] s:swap){
                int a = curr/pow[s[0]]%10;
                int b = curr/pow[s[1]]%10;
                if(isPrime(a+b)){
                    int nxt = curr + (b-a)*pow[s[0]] + (a-b)*pow[s[1]];

                    if(!shortestPath.containsKey(nxt)){
                        shortestPath.put(nxt, shortestPath.get(curr)+1);
                        q.offer(nxt);
                    }
                }
            }
        }
        return shortestPath;
    }

    private static int numberOfSwaps(ArrayList<ArrayList<Integer>> matrix, HashMap<Integer, Integer> shortestPath) {
        int num=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                num *= 10;
                num += matrix.get(i).get(j);
            }
        }
        if(shortestPath.containsKey(num)){
            return shortestPath.get(num);
        }else{
            return -1;
        }
    }

    private static boolean isPrime(int n){
        if(n==2 || n==3 || n==5 || n==7 || n==11 || n==13 || n==17 || n==19)
            return true;
        return false;
    }
}
