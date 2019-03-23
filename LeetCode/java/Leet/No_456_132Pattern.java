package Leet;

public class No_456_132Pattern {
    public static void main(String[] args){
        int[] nums = {1,3,2};
        System.out.println(new No_456_132Pattern().find132pattern(nums));
}
public boolean find132pattern(int[] nums){
    if(nums.length<3) return false;

    for(int i=0;i<nums.length;i++){
        int max = Integer.MIN_VALUE;
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]>max){
                max = nums[j];
            }else if(nums[j]>max&&nums[j]>nums[i]&&nums[i]<max){
                return true;
            }
        }

    }
    return false;
}



}