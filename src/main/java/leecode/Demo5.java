package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo5 {
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"  dabab
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//示例 2：
//
//输入: "cbbd"
//输出: "bb"

    public static void main(String[] args) {
//        System.out.println(new Demo5().longestPalindrome("naptionoranynarnotperishfrom"));
        System.out.println(longestPalindrome1("abcab"));
    }

    int start = 0;
    int end = 1;


    public static int longestPalindrome1(String s) {
        if (s.length() == 0)
            return 0;
        // 用于存放字符
        HashSet<Character> hashset = new HashSet<Character>();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!hashset.contains(chars[i])) {// 如果hashset没有该字符就保存进去
                hashset.add(chars[i]);
            } else {// 如果有,就让count++（说明找到了一个成对的字符），然后把该字符移除
                hashset.remove(chars[i]);
                count++;
            }
        }
        return hashset.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        char[] c = s.toCharArray();

        longest(c, length >> 1, 0);
        return s.substring(start, end);
    }

    void longest(char[] c, int index, int flag) {


        if (index > c.length - 1 || index < 0) return;

        int start_ = index, end_ = index;
        while (end_ + 1 < c.length && c[end_] == c[end_ + 1]) {
            ++end_;
        }
        while (start_ - 1 >= 0 && c[start_] == c[start_ - 1]) {
            --start_;
        }

        --start_;
        ++end_;
        index = end_;
        int index1 = start_;
        while (start_ >= 0 && end_ < c.length && c[start_] == c[end_]) {
            --start_;
            ++end_;
        }
        if (end_ - start_ - 1 > end - start) {
            start = start_ + 1;
            end = end_;
        }

        int l = end - start;

        if (flag >= 0 && l < c.length - index << 1) {
            longest(c, index, 1);
        }
        if (flag <= 0 && l < index1 << 1) {
            longest(c, index1, -1);
        }

    }

}