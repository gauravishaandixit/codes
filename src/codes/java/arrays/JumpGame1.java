package codes.java.arrays;

public class JumpGame1 {

    int canJump(int[] arr) {
        int maxReach = arr[0];

        for(int i = 1; i < arr.length; i++)
        {
            if(maxReach < i)
                return 0;

            maxReach = Math.max(maxReach, i + arr[i]);
        }
        return 1;
    }
}
