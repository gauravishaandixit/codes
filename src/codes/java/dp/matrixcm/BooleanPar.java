package codes.java.dp.matrixcm;

public class BooleanPar {


    int numWays(String expr)
    {
        return numWaysForType(expr, 0, expr.length() - 1, 'T');
    }

    int numWaysForType(String expr,int i, int j, char value)
    {
        if(i > j)
            return 0;
        if( i == j)
            return expr.charAt(i) == value ? 1 : 0;

        int ans = 0;
        for(int k = i + 1; k < j; k += 2)
        {
            int leftT = numWaysForType(expr, i, k - 1, 'T');
            int rightT = numWaysForType(expr, k + 1, j, 'T');
            int leftF = numWaysForType(expr, i, k - 1, 'F');
            int rightF = numWaysForType(expr, k + 1, j, 'F');

            /*
            if(expr.charAt(k) == '|')
            {
                if(value == 'T')
                    ans += (leftF * rightT + leftT * rightF + leftT * rightT);
                else
                    ans += (leftF * rightF);
            }
            else
            {
                if(expr.charAt(k) == '&')
                {
                    if(value == 'T')
                        ans += (leftT * rightT);
                    else
                        ans += (leftF * rightT + leftT * rightF + leftF * rightF);
                }
                else
                {
                    if(value == 'T')
                        ans += (leftF * rightT + leftT * rightF);
                    else
                        ans += (leftT * rightT + leftF * rightF);
                }
            }*/


            switch (expr.charAt(k))
            {
                case '|' : switch (value)
                            {
                                case 'T' : ans += (leftF * rightT +  leftT * rightF + leftT * rightT); break;
                                case 'F' : ans += (leftF * rightF); break;
                            }
                            break;
                case '&' : switch (value)
                            {
                                case 'T' : ans += (leftT * rightT); break;
                                case 'F' : ans += (leftF * rightT + leftT * rightF + leftF * rightF); break;
                            }
                            break;
                case '^' : switch (value)
                            {
                                case 'T' : ans += (leftF * rightT + leftT * rightF); break;
                                case 'F' : ans += (leftT * rightT + leftF * rightF);break;
                            }
                            break;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(new BooleanPar().numWays("T|T&F^T")); // 4
        System.out.println(new BooleanPar().numWays("T^F&T")); // 2
        System.out.println(new BooleanPar().numWays("T^F|F")); // 2
    }
}
