package codes.java.takeUForward;

public class MajorityElement {
    int majorityElement(int[] arr) {
        int candidate = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if(count == 0)
                candidate = arr[i];
            if(arr[i] == candidate)
                count++;
            else
                count--;
        }
        return count > 0 ? candidate : -1;
    }
}
