package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo17 {
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//
//
//示例：
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//提示：
//
//    3 <= nums.length <= 10^3
//    -10^3 <= nums[i] <= 10^3
//    -10^4 <= target <= 10^4

    public static void main(String[] args) {
        System.out.println(new Demo17().letterCombinations("23"));
    }

    String[] a = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        round(digits, "");
        return result;
    }

    private void round(String digits, String cache) {
        char c = digits.charAt(0);
        String substring = digits.substring(1);
        String len = a[Integer.valueOf("" + c) - 2];
        if (digits.length() == 1) {
            for (int i = 0; i < len.length(); i++) {
                result.add(cache + len.charAt(i));
            }
            return;
        }
        for (int i = 0; i < len.length(); i++) {
            round(substring, cache + len.charAt(i));
        }

    }
}