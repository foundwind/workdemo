package leecode;

import java.util.Stack;

public class Demo224 {

    public static void main(String[] args) {
        System.out.println(new Demo224().calculate("(2147483647 + 1"));
    }

    public int calculate(String s) {

        Stack<Stack<String>> caleList = new Stack<>();
        // 底仓
        caleList.push(new Stack<>());

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() != 0) {
                    caleList.peek().push(sb.toString());
                    sb.delete(0, sb.length());
                }
                continue;
            }
            if (c == '(') {
                // 先入库
                if (sb.length() != 0) {
                    caleList.peek().push(sb.toString());
                    sb.delete(0, sb.length());
                }
                caleList.push(new Stack<>());
                continue;
            }
            if (c == ')') {
                if (sb.length() != 0) {
                    caleList.peek().push(sb.toString());
                    sb.delete(0, sb.length());
                }
                // 计算括号内的结果
                Stack<String> pop = caleList.pop();
                long sum = 0;
                while (!pop.isEmpty()) {
                    String rChar = pop.pop();
                    Long right = Long.valueOf(rChar);
                    // 如果括号只有一个数字直接跳出
                    if (pop.isEmpty()) {
                        sum += Long.valueOf(right);
                    } else {
                        String f = pop.pop();
                        // 计算结果
                        if (f.equals("+")) {
                            sum += Long.valueOf(right);
                        } else {
                            sum -= Long.valueOf(right);
                        }
                    }
                }
                caleList.peek().push(String.valueOf(sum));
                continue;
            }
            if (c == '+') {
                if (sb.length() != 0) {
                    caleList.peek().push(sb.toString());
                    sb.delete(0, sb.length());
                }
                caleList.peek().push(String.valueOf(c));
                continue;
            }
            if (c == '-') {
                if (sb.length() != 0) {
                    caleList.peek().push(sb.toString());
                    sb.delete(0, sb.length());
                }
                caleList.peek().push(String.valueOf(c));
                continue;
            }
            sb.append(c);

        }
        if (sb.length() != 0) {
            caleList.peek().push(sb.toString());
        }
        // 计算括号内的结果
        Stack<String> pop = caleList.pop();
        long sum = 0;
        while (!pop.isEmpty()) {
            String rChar = pop.pop();
            Long right = Long.valueOf(rChar);
            // 如果括号只有一个数字直接跳出
            if (pop.isEmpty()) {
                sum += Long.valueOf(right);
            } else {
                String f = pop.pop();
                // 计算结果
                if (f.equals("+")) {
                    sum += Long.valueOf(right);
                } else {
                    sum -= Long.valueOf(right);
                }
            }
        }
        return (int) sum;

    }
}