package codes.java.dp.lcsconcept;


//No of insertion and deletion to make S1 equal to S2
// S1:: heap   S2:: pea
// deletion 2, insertion 1

// find lcs
// S1 -> lcs deletion :: m - len(lcs)
// lcs -> S2 insertion:: n - lcs(lcs)
public class InsertionAndDeletion {

    int[] count(String s1, String s2)
    {
        int m = s1.length(), n = s2.length();
        int T[][] = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    T[i][j] = 1 + T[i - 1][j - 1];
                else
                    T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]);
            }
        }
        int deletion = m - T[m][n];
        int insertion = n - T[m][n];

        return new int[]{deletion, insertion};
    }

    public static void main(String[] args)
    {
        int ans[] = new InsertionAndDeletion().count("heap","pea");
        System.out.println("Deletions:: " + ans[0] + ", Insertions:: " + ans[1]);
    }

}
