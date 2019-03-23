package Leet;

//Given an array nums of n integers, are there elements a, b, c in nums such that
// a + b + c = 0?
// Find all unique triplets in the array which gives the sum of zero.
// Note:
// The solution set must not contain duplicate triplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_15_3Sum {

    public static void main ( String[] args ) {
        int[] nums = {-1, 0, 0, 1, 2, -2};
        System.out.println(threeSum(nums));


    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int iNum =Integer.MAX_VALUE ;
        int jNum;
        int kNum;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (iNum == nums[i]) {
                continue;
            }
            iNum = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);

                    jNum = nums[j];
                    do {
                        j++;
                        if (j>=k) {
                            break;
                        }
                    } while (jNum == nums[j]);
                    kNum = nums[k];
                    do {
                        k--;
                        if (j>=k) {
                            break;
                        }
                    } while (kNum == nums[k]);
                }
            }
        }
        return result;
    }
}