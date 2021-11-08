package leecode;

import java.util.Stack;

public class Demo71 {
//

    public static void main(String[] args) {
//        System.out.println(new Demo71().simplifyPath("/a/./b/../../c/"));
//        System.out.println(new Demo71().simplifyPath("/home//foo/"));
//        System.out.println(new Demo71().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new Demo71().simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        // 维持一个栈
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char[] chars = path.toCharArray();
        int len = chars.length;

        for (char c : chars) {
            if (c == '/') {
                if (sb.length() != 0) {
                    String str = sb.toString();
                    if (str.equals(".")) {

                    } else if (str.equals("..")) {
                        if (!stack.isEmpty()) stack.pop();
                    } else {
                        stack.push(str);
                    }
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() != 0){
            String str = sb.toString();
            if (str.equals(".")) {

            } else if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str);
            }
            sb.delete(0, sb.length());
        }

        if (stack.isEmpty()) return "/";

        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }

}