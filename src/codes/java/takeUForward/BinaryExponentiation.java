package codes.java.takeUForward;

public class BinaryExponentiation {
    double pow(int x, int n) {
        double ans = 1.0;
        long nn = (long) n;
        if(nn < 0)
            nn *= -1;

        while(nn > 0) {
            if(nn % 2 == 1) {
                ans = ans * x;
                nn -= 1;
            }
            else {
                x *= x;
                n /= 2;
            }
        }
        if(n < 0)
            ans = 1.0 / ans;
        return ans;
    }
}
