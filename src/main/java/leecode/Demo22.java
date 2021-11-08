package leecode;

import java.util.ArrayList;
import java.util.List;

public class Demo22 {
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
//示例 1：
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//示例 2：
//
//输入：n = 1
//输出：["()"]
//
//
//
//提示：
//
//    1 <= n <= 8
//


    public static void main(String[] args) {
        System.out.println(new Demo22().generateParenthesis(3));
    }

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        round(n, n, new StringBuilder());
        return list;
    }

    private void round(int leftCount, int rightCount, StringBuilder builder) {
        if (rightCount == 0) {
            list.add(builder.toString());
            return;
        }
        if (leftCount == rightCount) { //当前情况只能加左括号
            round(leftCount - 1, rightCount, builder.append("("));
            builder.deleteCharAt(builder.length() - 1);
        } else {
            round(leftCount, rightCount - 1, builder.append(")"));
            builder.deleteCharAt(builder.length() - 1);
            if (leftCount != 0) {
                round(leftCount - 1, rightCount, builder.append("("));
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }


}