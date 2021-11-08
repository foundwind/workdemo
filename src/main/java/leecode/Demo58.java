package leecode;

public class Demo58 {
//

    public static void main(String[] args) {
        System.out.println(new Demo58().lengthOfLastWord("   fly me   to   the moon  "));
    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != 32) {
                num++;
                for (int j = i - 1; j >= 0; j--) {
                    if (chars[j] != 32) {
                        num++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return num;
    }

}