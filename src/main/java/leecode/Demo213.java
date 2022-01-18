package leecode;

import java.util.Arrays;

public class Demo213 {

    public static void main(String[] args) {
        System.out.println(new Demo213().rob(new int[]{1, 2, 3, 1}));
    }

    int[] check;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        check = new int[nums.length];
        Arrays.fill(check, -1);
        int robMax = robMax(nums, 0, nums.length - 1);
        Arrays.fill(check, -1);
        return Math.max(robMax, robMax(nums, 1, nums.length));
    }

    private int robMax(int[] nums, int index, int len) {
        // 证明还可以偷东西
        if (index < len) {
            // 偷当前
            if (check[index] == -1) {
                check[index] = robMax(nums, index + 2, len) + nums[index];
            }
            if ((index + 1) < len && check[index + 1] == -1) {
                check[index + 1] = robMax(nums, index + 3, len) + nums[index + 1];
            }
            return Math.max(check[index], (index + 1) < len ? check[index + 1] : 0);

        }
        return 0;
    }

}