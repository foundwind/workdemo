package leecode;

public class Demo14 {
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//
//输入: ["flower","flow","flight"]
//输出: "fl"
//
//示例 2:
//
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//说明:
//
//所有输入只包含小写字母 a-z 。
//

    public static void main(String[] args) {
        String s = new Demo14().longestCommonPrefix(new String[]{"ab", "a"});
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String min = strs[0];
        int length = strs[0].length();
        int i = 0;
        for (; i < length; i++) {
            char c = min.charAt(i);
            for (String str : strs) {
                length = Math.min(length, str.length());
                if (length == 0) return "";
                if (str.charAt(i) != c) {
                    return min.substring(0, i);
                }
            }
        }
        return min.substring(0, i);

    }

}