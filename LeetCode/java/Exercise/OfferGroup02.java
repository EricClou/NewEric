package Exercise;

//在其他数字都出现2次的数组里面找到唯二只出现1次的数：[1, 1, 2, 2, 5, 3]

import java.util.ArrayList;
import java.util.Arrays;

public class OfferGroup02 {

    public static void main ( String[] args ) {
        int arr[] = {1, 2, 2, 1, 3, 5};
        System.out.println(new OfferGroup02().findOnce(arr));
    }

    public ArrayList <Integer> findOnce ( int[] arr ) {
        Arrays.sort(arr);
        ArrayList <Integer> ans = new ArrayList <>();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == arr[i + 1]) {
                i += 2;
            } else {
                if (i == arr.length - 2) {
                    ans.add(arr[i]);
                    ans.add(arr[i + 1]);
                    break;
                } else {
                    ans.add(arr[i]);
                    i++;
                }

            }
        }
        return ans;

    }
}
