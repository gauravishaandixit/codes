package codes.java.recursion;

public class Josephus_2 {

    //Recursive
    private int lastPerson(int n, int k)
    {
        if(n == 1)
            return n;
        return (lastPerson(n - 1, k) + k - 1) % n + 1;
    }



}
