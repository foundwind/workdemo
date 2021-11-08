package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo3 {
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//示例 1:
//
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//示例 2:
//
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//示例 3:
//
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static void main(String[] args) {
        System.out.println(new Demo3().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int left = 1;
        int length = s.length();
        int[] occurs = new int[128];

        int max = 0;
        for (int index = 0; index < length; index++) {
            char letter = s.charAt(index);
            if (occurs[letter] != 0) {
                int cache = index  - left+ 1;
                if (cache > max) max = cache;
                left =  Math.max(left,occurs[letter] + 1);
            }
            occurs[letter] = index + 1;
        }
        int f = length -  left+ 1;
        return max > f ? max : f;
    }

}