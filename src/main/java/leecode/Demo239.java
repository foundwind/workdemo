package leecode;

public class Demo239 {
//

    public static void main(String[] args) {
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        // 先找出最大值
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        result[0] = max;

        for (int i = 0; i < 1; i++) {

        }

        return result;
    }


}