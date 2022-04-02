package leecode;

import java.util.Arrays;
import java.util.List;

public class Demo301 {
//

    public static void main(String[] args) {
        new Demo301().removeInvalidParentheses(")(");
    }

    public List<String> removeInvalidParentheses(String s) {
        StringBuilder builder = new StringBuilder(s);
        //前后取出坏区间
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '(') break;
            if (builder.charAt(i) == ')') {
                builder = builder.deleteCharAt(i);
            }
        }
        for (int i = builder.length() - 1; i > -1; i--) {
            if (builder.charAt(i) == ')') break;
            if (builder.charAt(i) == '(') {
                builder = builder.deleteCharAt(i);
            }
        }
        // 然后正式进行拆除
        int left = 0;
        int right = 0;
        for (int i = 0; i < builder.length() - 1; i++) {
            if (builder.charAt(i) == ')') {
                right++;
            } else if (builder.charAt(i) == '(') {
                left++;
            }
        }
        if (left == right) {
            return Arrays.asList(builder.toString());
        }
        if (left > right) {
            int num = left - right;
            // 需要拆除左括号多少个
            // 找出所有的右括号位置

        } else {
            int num = right - left;
        }


        return null;
    }


}