package codes.java;

public class Dominos {

    int CreateDomino(int n)
    {
        int sum = 0;
        int mul = n;
        for(int i = 1; i <= n; i++)
        {
            sum += (i * mul);
            mul--;
        }
        return sum;
    }

    public static void main(String[] ar)
    {
        System.out.println(new Dominos().CreateDomino(4));
        System.out.println(new Dominos().CreateDomino(5));
    }

}
