package codes.java.arrays;

public class KadanesAlgo {
    class Ans {
        int start;
        int end;
        int maxSum;

        Ans(int s, int e, int sum)
        {
            start = s;
            end = e;
            maxSum = sum;
        }

        public String toString()
        {
            return "Start:: " + start + ", End:: " + end + ", Maximum Subarray Sum:: " + maxSum;
        }
    }

    Ans maximumContigousSubarraySum(int arr[])
    {
        int maxAns = Integer.MIN_VALUE;
        int currMax = 0;
        int s = 0;
        Ans ans = new Ans(-1, -1, Integer.MIN_VALUE);
        for(int i = 0; i < arr.length; i++)
        {
            currMax += arr[i];
            if(maxAns < currMax)
            {
                maxAns = currMax;
                ans = new Ans(s, i, maxAns);
            }

            if(currMax < 0)
            {
                currMax = 0;
                s = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Ans ans = new KadanesAlgo().maximumContigousSubarraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
        System.out.println(ans);


        ans = new KadanesAlgo().maximumContigousSubarraySum(new int[]{1,2,3,4, -20, 11});
        System.out.println(ans);
    }
}
