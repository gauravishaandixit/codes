package codes.java.takeUForward;

public class NextPermutation {
    void nextPermutation(int[] arr) {
        if(arr.length <= 1)
            return;

        int i = arr.length - 2;
        while(i >= 0 && arr[i] >= arr[i + 1])
            i--;


        if(i >= 0){
            int j = arr.length - 1;
            while(arr[j] <= arr[i])
                j--;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        reverse(arr, i + 1, arr.length - 1);

    }

    void reverse(int[] arr, int i, int j) {
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
