package leecode;

import java.math.BigDecimal;
import java.util.Arrays;

public class Demo33 {
//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
//在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
//给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
//示例 1：
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//示例 2：
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
//示例 3：
//
//输入：nums = [1], target = 0
//输出：-1
//
//提示：
//
//    1 <= nums.length <= 5000
//    -10^4 <= nums[i] <= 10^4
//    nums 中的每个值都 独一无二
//    题目数据保证 nums 在预先未知的某个下标上进行了旋转
//    -10^4 <= target <= 10^4


    public static void main(String[] args) {


        BigDecimal a = new BigDecimal("08");
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length < 286) {
            return findIndex(0, length, nums, target);
        } else {
            return round(0, length, nums, target);
        }
    }

    private int round(int start, int end, int[] nums, int target) {
        if (start - end <= 286) {
            return findIndex(start, end, nums, target);
        } else {
            int mid = (start + end) / 2;
            if (nums[start] == target) return start;
            if (nums[mid] == target) return mid;
            if (nums[end] == target) return end;


            if (nums[mid] < nums[end]) {
                if (target > nums[end]) {
                    return round(start + 1, mid -1, nums, target);
                }
                if (target > nums[mid]) {
                    return round(mid + 1, end - 1, nums, target);
                }
                return round(start + 1, mid - 1, nums, target);
            } else {
                if (target > nums[mid]) {
                    return round(mid + 1, end - 1, nums, target);
                }
                if (target > nums[start]) {
                    return round(start + 1, mid - 1, nums, target);
                }
                return round(mid + 1, end - 1, nums, target);
            }
        }

    }

    public int findIndex(int start, int end, int[] nums, int target) {
        int index = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] == target) return i;
        }
        return index;
    }

}