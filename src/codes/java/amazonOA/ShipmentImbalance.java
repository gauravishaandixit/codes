package codes.java.amazonOA;

// Not Correct

public class ShipmentImbalance {

    int shipmentImbalance(int[] arr) {
        int ans = 0;
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                //System.out.println(i + " " + j + " min: " + min +" max: " + max);

                ans += (max - min);
            }
        }

        System.out.println("Ans:: " + ans);

        return ans;
    }

    public static void main(String[] args) {
        new ShipmentImbalance().shipmentImbalance(new int[]{1,3,2});
        new ShipmentImbalance().shipmentImbalance(new int[]{1,2,3});
        new ShipmentImbalance().shipmentImbalance(new int[]{3,2,3});
    }

}
