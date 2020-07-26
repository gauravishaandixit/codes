package codes.java.twopointers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Duplicates
public class ThreeSumZero {
    ArrayList<ArrayList<Integer>> threeSumZero(int[] arr)
    {
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n - 1; i++)
        {
            while(i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1, k = n - 1;
            while(j < k)
            {
                int sum = arr[i] + arr[j] + arr[k];
                if( sum == 0)
                {
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add(arr[i]);
                    curr.add(arr[j]);
                    curr.add(arr[k]);
                    ans.add(curr);
                    j++;
                    k--;

                    while(j < k && arr[j] == arr[j - 1]) j++;
                    while(j < k && arr[k] == arr[k + 1]) k--;
                }
                else
                {
                    if(sum > 0)
                        k--;
                    else
                        j++;
                }
            }
        }

        return ans;
    }
}
