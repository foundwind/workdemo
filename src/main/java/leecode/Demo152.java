package leecode;

public class Demo152 {
    public static void main(String[] args) {
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        Integer max = Integer.MIN_VALUE;
        Integer maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i - 1] * nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }
        return Math.max(max, maxValue);
    }

}