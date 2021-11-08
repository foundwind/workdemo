package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Demo20 {
//

    public static void main(String[] args) {


    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            }else {
                Character character = map.get(c);
                if (stack.isEmpty() || !character.equals(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }


}