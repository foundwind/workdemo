package leecode;

public class Demo174 {
    public static void main(String[] args) {
        new Demo174().calculateMinimumHP(new int[][]{
                {-2, 3, -5, 3, 8, -10, 3}
        });
    }

    public int calculateMinimumHP(int[][] dungeon) {
        // 当前血宝
        int[][] health = new int[dungeon.length][dungeon[0].length];
        // 第一行
        int yLen = dungeon.length;
        int xLen = dungeon[0].length;
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                if (dungeon[i][j] > 0) { //是血包
                    health[i][j] = dungeon[i][j];
                    dungeon[i][j] = 0;
                } else {
                    dungeon[i][j] = -dungeon[i][j];
                }
            }
        }

        for (int i = 1; i < xLen; i++) {
            // 总血包
            health[0][i] += health[0][i - 1];
            if (dungeon[0][i] != 0) { //需要扣血
                // 如果当前血包大于扣血
                if (health[0][i] >= dungeon[0][i]) {
                    // 血包减少
                    health[0][i] -= dungeon[0][i];
                    // 不用扣血
                    dungeon[0][i] = dungeon[0][i - 1];
                } else {
                    // 扣血
                    dungeon[0][i] = dungeon[0][i - 1] + dungeon[0][i] - health[0][i];
                    // 血包清空
                    health[0][i] = 0;
                }
            } else {
                dungeon[0][i] = dungeon[0][i - 1];
            }
        }


        for (int i = 1; i < yLen; i++) {
            for (int j = 1; j < xLen; j++) {
                // 判断哪边消耗更少，就选取哪边
                if (dungeon[0][i] != 0) {

                } else { // 不需要扣血

                }

            }

        }

        return health[yLen - 1][xLen - 1];
    }

}