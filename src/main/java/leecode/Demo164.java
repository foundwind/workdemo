package leecode;

import java.util.Arrays;

public class Demo164 {
    public static void main(String[] args) {
        System.out.println(new Demo164().maximumGap(new int[]{1, 97, 98, 99, 100001}));
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int d = (max - min) / nums.length + 1;
        int bucket = (max - min) / d + 1;
        int[] bigger = new int[bucket];
        int[] smaller = new int[bucket];
        Arrays.fill(bigger, min - 1);
        Arrays.fill(smaller, max + 1);

        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - min) / d;
            bigger[idx] = Math.max(bigger[idx], nums[i]);
            smaller[idx] = Math.min(smaller[idx], nums[i]);
        }

        int ret = 0;
        int pre = bigger[0];
        for (int i = 1; i < bucket; i++) {
            if (smaller[i] != max + 1) {
                ret = Math.max(ret, smaller[i] - pre);
                pre = bigger[i];
            }
        }
        return ret;
    }
}