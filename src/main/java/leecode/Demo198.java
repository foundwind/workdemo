package leecode;

import java.util.Arrays;

public class Demo198 {
    public static void main(String[] args) {
        System.out.println(new Demo198().rob(new int[]{1, 2, 3, 1}));
    }

    int[] check;

    public int rob(int[] nums) {
        check = new int[nums.length];
        Arrays.fill(check, -1);
        return robMax(nums, 0);
    }

    private int robMax(int[] nums, int index) {
        // 证明还可以偷东西
        if (index < nums.length) {
            // 偷当前
            if (check[index] != -1) {
                check[index] = robMax(nums, index + 2) + nums[index];
            }
            if ((index + 1) < nums.length && check[index + 1] != -1) {
                check[index + 1] = robMax(nums, index + 3) + nums[index + 1];
            }
            return Math.max(check[index], (index + 1) < nums.length ? check[index + 1] : 0);

        }
        return 0;
    }

}