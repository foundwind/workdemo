package leecode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Demo32 {
//

    public static void main(String[] args) {
        System.out.println(new Demo32().longestValidParentheses("(())()(()(("));

    }

    public int longestValidParentheses(String s) {


        int[] dp = new int[s.length()];
        int max = 0;

        int cache = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
                    cache = dp[i];
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 1 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                    cache = dp[i];
                } else {
                    max = max > cache ? max : cache;
                }
            }
            max = max > cache ? max : cache;
        }
        return  max > cache ? max : cache;
    }

}