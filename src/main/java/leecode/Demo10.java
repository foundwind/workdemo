package leecode;

public class Demo10 {
//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//    '.' 匹配任意单个字符
//    '*' 匹配零个或多个前面的那一个元素
//
//所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
//示例 1：
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//示例 2:
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//示例 3：
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//示例 4：
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//示例 5：
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
//提示：
//
//    0 <= s.length <= 20
//    0 <= p.length <= 30
//    s 可能为空，且只包含从 a-z 的小写字母。
//    p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
//    保证每次出现字符 * 时，前面都匹配到有效的字符
//

    public static void main(String[] args) {
        System.out.println(new Demo10().isMatch("aab", "c*a*b"));
    }

    int[][] map;

    public boolean isMatch(String s, String p) {
        char[] strc = s.toCharArray();
        char[] strp = p.toCharArray();

        map = new int[strc.length][strp.length];
        return dp(strc, 0, strp, 0);

    }

    public boolean dp(char[] s, int sStand, char[] p, int pStand) {

        int sLen = s.length;
        int pLen = p.length;

        if (pStand == pLen) {
            return sStand == sLen;
        }

        // base case
        if (sStand == sLen) {
            // 不可能使用 * 匹配
            if ((pLen - pStand) % 2 == 1) return false;

            for (; pStand + 1 < pLen; pStand += 2) {
                if (p[pStand + 1] != '*') {
                    return false;
                }
            }
            return true;
        }

        // 消除重叠子问题
        if (map[sStand][pStand] == 1) return false;
        else if (map[sStand][pStand] == 2) return true;


        boolean res;

        // 匹配
        if (s[sStand] == p[pStand] || p[pStand] == '.') {
            // 通配符匹配 0 次或多次
            if (pStand < pLen - 1 && p[pStand + 1] == '*') {
                // 匹配多次
                res = dp(s, sStand + 1, p, pStand)
                        // 匹配0次
                        || dp(s, sStand, p, pStand + 2);
            }
            // 直接匹配
            else {
                res = dp(s, sStand + 1, p, pStand + 1);
            }
        }
        // 不匹配
        else {
            // 通配符匹配 0 次
            if (pStand < pLen - 1 && p[pStand + 1] == '*') {
                res = dp(s, sStand, p, pStand + 2);
            } else {
                res = false;
            }
        }

        // 消除重叠子问题
        if (res == false) map[sStand][pStand] = 1;
        else map[sStand][pStand] = 2;

        return res;
    }

}