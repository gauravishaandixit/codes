package codes.java;

public class Main {

    int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles < numExchange)
            return numBottles;

        int ans = numBottles;
        while(true)
        {
            ans += numBottles/numExchange;
            numBottles = (numBottles/numExchange) + (numBottles % numExchange);
            if(numBottles < numExchange)
                break;
        }
        return ans;
    }
    public static void main(String[] args) {
        Main obj = new Main();

        System.out.println(obj.numWaterBottles(9, 3));
        System.out.println(obj.numWaterBottles(15, 4));
        System.out.println(obj.numWaterBottles(5,5));
        System.out.println(obj.numWaterBottles(2, 3));
    }
}
