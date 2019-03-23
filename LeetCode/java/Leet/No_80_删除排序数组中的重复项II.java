package Leet;

//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
public class No_80_删除排序数组中的重复项II {

    public static void main ( String[] args ) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates ( int[] nums ) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int number = 1;
        int i = 0;
        int begin = 0;
        while (i < nums.length - 1) {
            while (nums[i] == nums[i + 1]) {
                number++;
                i++;
                if (i == nums.length - 1) break;
            }
            if (number == 1) {
                nums[begin++] = nums[i];
            }else  {
                number = 1;
                nums[begin++] = nums[i];
                nums[begin++] = nums[i];

            }
            i++;

        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            nums[begin++] = nums[nums.length - 1];
        }
        return begin;
    }

}
