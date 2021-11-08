package leecode;

public class Demo20test {
//

    public static void main(String[] args) {
        System.out.println(new Demo20test().isValid("(())"));
        System.out.println(new Demo20test().isValid("()[]{}"));
        System.out.println(new Demo20test().isValid("(]"));
        System.out.println(new Demo20test().isValid("([)]"));
        System.out.println(new Demo20test().isValid("{[]}"));
    }


    int l1 = 0;
    int l2 = 0;
    int l3 = 0;
    int level = 0;

    public boolean isValid(String s) {
        int length = s.length();
        if (length == 0) return false;
        for (int i = 0; i < length; i++) {
            if (!check(s.charAt(i))) return false;
        }


        return level == 0;
    }

    private boolean check(char charAt) {
        switch (charAt) {
            case '{':
                if (level != 0) return false;
                l1++;
                level = 1;
                return true;
            case '[':
                if (level > 2) return false;
                l2++;
                level = 2;
                return true;
            case '(':
                l3++;
                level = 3;
                return true;
            case ')':
                if (level != 3 || l3 == 0) return false;
                l3--;
                makeLevel();
                return true;
            case ']':
                if (level != 2 || l2 == 0) return false;
                l2--;
                makeLevel();
                return true;
            case '}':
                if (level != 1 || l1 == 0) return false;
                l1--;
                makeLevel();
                return true;
            default:
                return false;
        }
    }

    private void makeLevel() {
        if (l3 != 0) {
            level = 3;
        } else if (l2 != 0) {
            level = 2;
        } else if (l1 != 0) {
            level = 1;
        } else {
            level = 0;
        }
    }

}