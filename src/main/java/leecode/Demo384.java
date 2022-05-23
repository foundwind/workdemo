package com.wangchangjing.simple.controller;

/**
 * @author WangChangJing
 * @date 2022/5/17
 */
public class Demo384 {
    public static void main(String[] args) {
        System.out.println((int) ('A' - 0));
        System.out.println((int) ('z' - 0));
        new Demo384().PredictTheWinner(new int[]{ 0,0,7,6,5,6,1});
    }


    public boolean PredictTheWinner(int[] nums) {
        if (nums.length <= 2) return true;
        if (nums.length == 3) return nums[1] <= nums[0] + nums[2];
        int one = 0;
        int two = 0;
        int left = 0;
        int right = nums.length - 1;

        boolean round = true;
        int[] leftDif = new int[nums.length];
        int[] rightDif = new int[nums.length];

        init(nums, leftDif, rightDif);


        while (left <= right) {
            if (leftDif[left] >= rightDif[right]) {
                if (round) {
                    one += nums[left];
                } else {
                    two += nums[left];
                }
                round = !round;
                left++;
            } else {
                if (round) {
                    one += nums[right];
                } else {
                    two += nums[right];
                }
                round = !round;
                right--;
            }
        }


        return one >= two;
    }

    private void init(int[] nums, int[] leftDif, int[] rightDif) {
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
                continue;
            }
            int dif = nums[i] - nums[i + 1];
            for (int j = 0; j < count; j++) {
                leftDif[i - j] = dif;
                dif ++;
            }
            count = 1;
        }

        count = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] == nums[i]) {
                count++;
                continue;
            }
            int dif = nums[i] - nums[i - 1];
            for (int j = 0; j < count; j++) {
                rightDif[i + j] = dif;
                dif++;
            }
            count = 1;
        }
    }

}
