package leecode;

import org.apache.commons.lang3.StringUtils;

public class Demo97 {
//

    public static void main(String[] args) {
        System.out.println(new Demo97().isInterleave("aabcc", "dbbca", "aadbbbccca"));
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        int xLen = s1.length();
        int yLen = s2.length();
        int sumLen = s3.length();
        if (xLen + yLen != sumLen) return false;


        boolean[][] dymArr = new boolean[xLen + 1][yLen + 1];
        dymArr[0][0] = true;
        // 初始化x
        boolean nextFlag = false;
        for (int i = 0; i < xLen; i++) {
            boolean b = s3.charAt(i) == s1.charAt(i);
            if (!b) break;
            dymArr[i + 1][0] = true;
            nextFlag = true;
        }
        for (int i = 0; i < yLen; i++) {
            boolean b = s3.charAt(i) == s2.charAt(i);
            if (!b) break;
            dymArr[0][i + 1] = true;
        }

        for (int y = 1; y <= yLen; y++) {
            //是否需要继续计算
            if (!nextFlag && !dymArr[0][y]) break;
            nextFlag = true;
            for (int x = 1; x <= xLen; x++) {
                boolean flag = (dymArr[x - 1][y] && s1.charAt(x - 1) == s3.charAt(x + y - 1))
                        || (dymArr[x][y - 1] && s2.charAt(y - 1) == s3.charAt(x + y - 1));
                if (flag) {
                    dymArr[x][y]= nextFlag = flag;
                }
            }


        }
        return dymArr[xLen][yLen];
    }
}