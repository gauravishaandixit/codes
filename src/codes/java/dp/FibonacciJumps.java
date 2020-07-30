package codes.java.dp;

public class FibonacciJumps {
    class State
    {
        int jump;
        int minJump;

        State(int jump, int minJump)
        {
            this.jump = jump;
            this.minJump = minJump;
        }

        public String toString()
        {
            return "Jump:: " + jump + " MinJump:: " + minJump;
        }
    }
    int[] minJumps(int arr[])
    {
        int n = arr.length;
        int fib[] = new int[30];
        fib[0] = 0;
        fib[1] = 1;

        for(int i = 2; i < 30; i++)
            fib[i] = fib[i - 1] + fib[i - 2];

        State[] T = new State[n + 2];
        T[0] = new State(0,0);

        for(int i = 1; i < n + 2; i++)
            T[i] = new State(0, n);

        for(int i = 1; i <= n + 1; i++)
        {
            for(int j = 1; j < 30; j++)
            {
                if((i == n + 1 || arr[i - 1] == 1) &&  i - fib[j] >= 0)
                {
                    if(T[i].minJump > 1 + T[i -fib[j]].minJump)
                    {
                        T[i] = new State(fib[j],1 + T[i -fib[j]].minJump);
                    }
                }
            }
        }

        for(int i = 0; i < n + 2; i++)
            System.out.println(T[i]);

        System.out.println(T[n + 1].minJump == n ? -1 : T[n + 1].minJump);
        int[] ans = new int[n];
        if(T[n + 1].minJump == n)
            return ans;
        int start = n + 1;

        while(start > 0)
        {
            start -= T[start].jump;
            if(start > 0)
                ans[start - 1] = 1;
        }

        return ans;
    }

    static void printArray(int[] arr)
    {
        for(int n: arr)
            System.out.print(n + " ");

        System.out.println();
    }
    public static void main(String[] ar)
    {
        int[] building = new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        int ans[] = new FibonacciJumps().minJumps(building);
        printArray(building);
        printArray(ans);

        System.out.println();

        building = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        ans = new FibonacciJumps().minJumps(building);
        printArray(building);
        printArray(ans);


        System.out.println();

        building = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0};
        ans = new FibonacciJumps().minJumps(building);
        printArray(building);
        printArray(ans);


        System.out.println();

        building = new int[]{0, 0, 0, 0, 0, 0, 0};
        ans = new FibonacciJumps().minJumps(building);
        printArray(building);
        printArray(ans);
    }
}
