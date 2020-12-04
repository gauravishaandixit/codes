package codes.java.recursion;


// k = 2;
// ans is n - (1's complement of the number)
public class Josephus_1 {

    int lastPerson(int n)
    {
        if((n & (n - 1)) == 0)
            return 1;

        return n - ~(n);
    }

    public static void main(String[] args)
    {
        System.out.println(new Josephus_1().lastPerson(8));
        System.out.println(new Josephus_1().lastPerson(9));
        System.out.println(new Josephus_1().lastPerson(6));
        System.out.println(new Josephus_1().lastPerson(4));
    }
}
