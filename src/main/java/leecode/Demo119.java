package leecode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo119 {
//

    public static void main(String[] args) {
        System.out.println(new Demo119().getRow(3));
    }


    public List<Integer> getRow(int rowIndex) {
        int[] result1 = new int[rowIndex + 1];
        int[] result2 = new int[rowIndex + 1];
        // 填充
        rowIndex++;
        for (int i = 0; i < rowIndex; i++) {
            if ((i & 1) == 0) { // 如果是第一行
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        result1[j] = 1;
                    } else {
                        result1[j] = result2[j] + result2[j - 1];
                    }
                }
            } else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        result2[j] = 1;
                    } else {
                        result2[j] = result1[j] + result1[j - 1];
                    }
                }
            }


        }
        if ((rowIndex & 1) == 1) {// 奇数
            return Arrays.stream(result1).boxed().collect(Collectors.toList());
        } else {
            return Arrays.stream(result2).boxed().collect(Collectors.toList());
        }
    }

}