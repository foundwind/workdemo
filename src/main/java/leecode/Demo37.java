package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo37 {
    //[请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
//
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//
//数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//注意：
//
//    一个有效的数独（部分已被填充）不一定是可解的。
//    只需要根据以上规则，验证已经填入的数字是否有效即可。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-sudoku
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}}

    public static void main(String[] args) {
        new Demo37().solveSudoku(new char[][]{{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}}
        );

    }

    boolean outFlag = false;
    int[] rows = new int[9]; //行的位运算数组
    int[] cols = new int[9]; //列的位运算数组
    int[] boxes = new int[9]; //方格的位运算数组


    Map<Integer, Integer> map = new HashMap<>();

    List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        map.put(510, 0);
        map.put(509, 1);
        map.put(507, 2);
        map.put(503, 3);
        map.put(495, 4);
        map.put(479, 5);
        map.put(447, 6);
        map.put(383, 7);
        map.put(255, 8);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int hash = i / 3 * 3 + j / 3;
                    int tmp = board[i][j] - '0' - 1;
                    rows[i] = 1 << tmp | rows[i];
                    cols[j] = 1 << tmp | cols[j];
                    boxes[hash] = 1 << tmp | boxes[hash];
                }
            }
        }

        while (true) {
            boolean ok = true;

            for (int[] space : spaces) {
                int i = space[0], j = space[1];
                if (board[i][j] == '.') {
                    int hash = i / 3 * 3 + j / 3;
                    int key = rows[i] | cols[j] | boxes[hash];
                    Integer index = map.get(key);

                    if (index != null) {
                        rows[i] = 1 << index | rows[i];
                        cols[j] = 1 << index | cols[j];
                        boxes[hash] = 1 << index | boxes[hash];
                        board[i][j] = (char) ('0' + index + 1);
                        ok = false;
                    }

                }
            }
            if (ok) break;
        }



        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }


        dfs(board, 0);
        System.out.println(1);

    }

    private void dfs(char[][] board, int pos) {
        if (spaces.size() == pos) {
            outFlag = true;
            return;
        }

        int[] ints = spaces.get(pos);
        int i = ints[0];
        int j = ints[1];



        for (int k = 0; k < 9; k++) {
            if (outFlag) break;



            int hash = i / 3 * 3 + j / 3;
            int mask = rows[i] | cols[j] | boxes[hash];
            int number = (mask >> k) & 1;
            if (number == 0) { //代表可以进入
                board[i][j] = (char) ('0' + k + 1);
                rows[i] = 1 << k | rows[i];
                cols[j] = 1 << k | cols[j];
                boxes[hash] = 1 << k | boxes[hash];
                dfs(board, pos + 1);
                rows[i] = 1 << k ^ rows[i];
                cols[j] = 1 << k ^ cols[j];
                boxes[hash] = 1 << k ^ boxes[hash];
            }

        }
    }

}