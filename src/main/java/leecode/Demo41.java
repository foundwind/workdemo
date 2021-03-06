package leecode;

public class Demo41 {
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
//
//
//示例 1：
//
//输入：nums = [1,2,0]
//输出：3
//
//示例 2：
//
//输入：nums = [3,4,-1,1]
//输出：2
//
//示例 3：
//
//输入：nums = [7,8,9,11,12]
//输出：1
//
//
//
//提示：
//
//    1 <= nums.length <= 5 * 105
//    -231 <= nums[i] <= 231 - 1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/first-missing-positive
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        new Demo41().firstMissingPositive(new int[]{1});
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int num : nums) {
            if (num > 0 && num <= length) {
                result[num - 1] = 1;
            }
        }
        int index = 0;
        for (int i : result) {
            index++;
            if (i == 0) return index;
        }
        return length + 1;
    }


}