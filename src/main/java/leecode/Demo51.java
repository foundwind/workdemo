package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo51 {
//

    public static void main(String[] args) {

    }
    List<List<String>> result = new ArrayList<>();
    int part = 0;
    int length = 0;
    static int EMPTY = 0;
    static int POINT = 1;
    static int ERROR = 2;

    public List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            result.add(Arrays.asList("Q"));
            return result;
        }
        part = (n + 1) / 2;
        length = n;
        for (int i = 0; i < part; i++) {
            dfs(new int[n][n], 0, i);
        }
        return result;
    }

    private void dfs(int[][] cache, int high, int index) {
        cache[high][index] = POINT;
        if (high == length - 1) {
            solve(cache);
            return;
        }
        //填充，并判断是否继续循环
        fill(cache, high, index);
        for (int i = 0; i < length; i++) {
            if (cache[high + 1][i] == EMPTY) {
                dfs(copy(cache), high + 1, i);
            }
        }

    }

    private void solve(int[][] cache) {
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (cache[0][i] == POINT) {
                index = i;
                break;
            }
        }
        if (length - 1 - index == index) {
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < length; j++) {
                    buffer.append(cache[i][j] == POINT ? "Q" : ".");
                }
                strings.add(buffer.toString());
            }
            result.add(strings);
        }else {
            List<String> strings = new ArrayList<>();
            List<String> strings2 = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < length; j++) {
                    buffer.append(cache[i][j] == POINT ? "Q" : ".");
                }
                strings.add(buffer.toString());
                strings2.add(buffer.reverse().toString());
            }
            result.add(strings);
            result.add(strings2);
        }
    }

    private void fill(int[][] cache, int high, int index) {
        for (int i = high + 1; i < length; i++) {
            cache[i][index] = ERROR;
            int right = index + i - high;
            int left = index - i + high;
            if (right < length) cache[i][right] = ERROR;
            if (left > -1) cache[i][left] = ERROR;
        }
    }

    private int[][] copy(int[][] cache) {
        int[][] copyArray = new int[length][length];
        for (int i = 0; i < length; i++) {
            copyArray[i] = Arrays.copyOf(cache[i], length);
        }
        return copyArray;
    }

}