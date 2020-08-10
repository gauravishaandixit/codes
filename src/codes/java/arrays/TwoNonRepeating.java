package codes.java.arrays;

public class TwoNonRepeating {

    int[] twoNonRepeating(int[] nums)
    {
        int totalXor = 0;
        int num1 = 0;
        int num2 = 0;

        for(int num: nums)
            totalXor ^= num;

        int firstSetBit = totalXor & ~(totalXor - 1);

        for(int num: nums)
        {
            if((num & firstSetBit) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }


}
