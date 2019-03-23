package Leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class No_18_4Sum {

    public static void main ( String[] args ) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new No_18_4Sum().fourSum(nums, target));
    }

    public List <List <Integer>> fourSum ( int[] nums, int target ) {
        Arrays.sort(nums);
        List <List <Integer>> res = new ArrayList <List <Integer>>();
        if (nums.length < 4) {
            return res;
        }
        int t, tt, f, l;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            t = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                tt = t - nums[j];
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                f = j + 1;
                l = nums.length - 1;
                while (f < l) {
                    if (nums[f] + nums[l] == tt) {
                        List <Integer> li = new ArrayList <Integer>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[f]);
                        li.add(nums[l]);
                        res.add(li);
                        while (f < l && nums[f] == nums[f + 1]) {
                            f++;
                        }
                        f++;
                        l--;
                    } else if (nums[f] + nums[l] < tt) {
                        f++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return res;
    }
}