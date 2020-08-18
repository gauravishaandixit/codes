package codes.java.Hackerearth.CodeVita;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Election {
    static class CellTime
    {
        int aTime;
        int bTime;

        CellTime()
        {
            aTime = Integer.MAX_VALUE;
            bTime = Integer.MAX_VALUE;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] queue = br.readLine().toCharArray();
        CellTime[] t = new CellTime[n];

        for(int i = 0; i < n; i++)
            t[i] = new CellTime();

        fillCellTime(queue, t, n);

        int totalA = 0, totalB = 0;
        for(int i = 0; i < n; i++)
        {
            if(queue[i] == 'A')
                totalA++;
            else
            {
                if(queue[i] == 'B')
                    totalB++;
                else
                {
                    if(t[i].aTime < t[i].bTime)
                        totalA++;
                    else
                    {
                        if(t[i].bTime < t[i].aTime)
                            totalB++;
                    }
                }
            }
        }

        if(totalA > totalB)
            System.out.println("A");
        else
        {
            if(totalB > totalA)
                System.out.println("B");
            else
                System.out.println("Coalition government");
        }
    }

    private static void fillCellTime(char[] queue, CellTime[] t, int n)
    {
        for(int i = 0; i < n; i++)
        {
            int time = 0;
            if(queue[i] == 'A')
            {
                int j = i - 1;
                while(j >= 0)
                {
                    if(queue[j] == '-')
                        t[j].aTime = Math.min(t[j].aTime, time);
                    else
                        break;

                    j--;
                    time++;
                }
            }
            else
            {
                if(queue[i] == 'B')
                {
                    int j = i + 1;
                    while(j < n)
                    {
                        if(queue[j] == '-')
                            t[j].bTime = Math.min(t[j].bTime, time);
                        else
                            break;
                        j++;
                        time++;
                    }
                }
            }
        }
    }
}
