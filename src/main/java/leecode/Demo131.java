package leecode;

import java.util.ArrayList;
import java.util.List;

public class Demo131 {
//

    public static void main(String[] args) {
        new Demo131().partition("aaba");
    }


    List<List<String>> result = new ArrayList<>();
    Integer len = 0;
    private int[][] checkOk;

    public List<List<String>> partition(String s) {
        if (s.length() == 0) return result;
        len = s.length();
        checkOk = new int[len][len];
        char[] chars = s.toCharArray();
        dfs(chars, 0, new ArrayList<>());
        return result;
    }

    private void dfs(char[] chars, int start, List<String> cache) {
        if (start == len) {
            result.add(new ArrayList<>(cache));
        }
        for (int i = start; i < chars.length; i++) {
            boolean check = checkIsRound(chars, start, i);
            if (check) {
                // 如果不是就应该没有后续操作
                cache.add(String.valueOf(chars, start, i - start + 1));
                dfs(chars, i + 1, cache);
                cache.remove(cache.size() - 1);
            } else {
                continue;
            }
        }
    }

    private boolean checkIsRound(char[] chars, int start, int end) {
        if (checkOk[start][end] != 0) {
            return checkOk[start][end] == 1;
        }

        while (start < end) {
            if (chars[start] != chars[end]) {
                checkOk[start][end] = 2;
                return false;
            }
            start++;
            end--;
        }
        checkOk[start][end] = 1;
        return true;
    }

}