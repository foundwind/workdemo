package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo1 {
//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
// 
//
//示例:
//
//给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/two-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        int[] ints = new Demo1().twoSum(new int[]{0, 4, 3, 0}, 0);
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2048];
        for (int i = 0; i < nums.length; i++) {
            // -1000 -  1000
            int num = nums[i];

            int mid = ints[(target - num) & 2047];

            if (mid != 0) {
                return new int[]{i, mid - 1};
            }
            ints[num & 2047] = i + 1;
        }

        return new int[0];

    }


}