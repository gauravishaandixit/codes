package codes.java.arrays;

public class GasStation {

    int canCompleteCircuit(int[] gas, int[] cost)
    {
        int n = gas.length;
        int i;
        for(i = 0; i < n; i++)
        {
            int curr = i;
            int rem = 0;
            int path = 0;

            while((path < n) && ((rem + gas[curr]) >= cost[curr]))
            {
                path++;
                rem = (rem + gas[curr]) - cost[curr];
                curr = (curr + 1) % n;
            }

            if(path == n)
                break;
        }
        return i == n ? -1 : i;
    }
}
