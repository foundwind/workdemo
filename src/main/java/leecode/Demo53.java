package leecode;

public class Demo53 {
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cache = nums[0] < 0 ? 0 : nums[0];
        for (int i = 1; i < nums.length; i++) {
            cache += nums[i];
            if (cache > max) max = cache;
            if (cache < 0) cache = 0;
        }
        return max;
    }

}