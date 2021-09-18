package codes.java.dp.matrixcm;

public class EggDrop2EggsNFloors {

    int minWays(int floors) {
        if(floors == 0)
            return 0;
        if(floors == 1)
            return 1;

        int[][] T = new int[3][floors + 1];
        for(int i = 0; i < 3; i++)
            T[i][1] = 1;

        for(int i = 1; i <= floors; i++)
            T[1][i] = i;

        for(int i = 2; i < 3; i++) {
            for(int j = 2; j <= floors; j++) {
                T[i][j] = Integer.MAX_VALUE;
                int res = 0;
                for(int x = 1; x <= j; x++) {
                    res = 1 + Math.max(T[i - 1][x - 1], T[i][j - x]);
                    T[i][j] = Math.min(T[i][j], res);
                }
            }
        }

        return T[2][floors];
    }

    public static void main(String[] args) {

    }




}
