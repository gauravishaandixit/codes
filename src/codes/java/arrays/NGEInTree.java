package codes.java.arrays;

// Not Complete

public class NGEInTree {

    int ngeInTree(int[] arr, int k) {
        int i = 0;
        while(i < arr.length) {
            if(arr[i] == k)
                return k;
            if(arr[i] > k) {
                i = i * 2 + 1;
            } else {
                i = i * 2 + 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NGEInTree().ngeInTree(new int[]{10, 5, 15, 2, 8, 12, 16}, 5));
        System.out.println(new NGEInTree().ngeInTree(new int[]{10, 5, 15, 2, 8, 12, 16}, 17));
        System.out.println(new NGEInTree().ngeInTree(new int[]{10, 5, 15, 2, 8, 12, 16}, 1));
        System.out.println(new NGEInTree().ngeInTree(new int[]{10, 5, 15, 2, 8, 12, 16}, 10));
        System.out.println(new NGEInTree().ngeInTree(new int[]{10, 5, 15, 2, 8, 12, 16}, 1));
    }

}
