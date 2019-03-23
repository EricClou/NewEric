package Leet;

import java.util.Arrays;

public class No_16_3SumClosest {

    public int threeSumClosest ( int[] nums, int target ) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    return target;
                }

            }
        }
        return closestNum;
    }


    public static void main ( String[] args ) {
        int[] nums = {1, 2, 5, -1, -5, 3, 1, 2};
        System.out.println(new No_16_3SumClosest().threeSumClosest(nums, 3));
    }
}
