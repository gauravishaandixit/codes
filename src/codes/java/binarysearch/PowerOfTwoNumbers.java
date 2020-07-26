package codes.java.binarysearch;

public class PowerOfTwoNumbers {

    double power(double x, int n)
    {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0)
        {
            if ((m & 1) == 1)
                ans *= x;

            x *= x;

            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
    }
}
