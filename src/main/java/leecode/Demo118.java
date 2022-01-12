package leecode;

import java.util.ArrayList;
import java.util.List;

public class Demo118 {
//

    public static void main(String[] args) {
        System.out.println(new Demo118().generate(3));
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return new ArrayList<>();

        // 填充
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<>(i));
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    result.get(i).add(1);
                } else {
                    result.get(i).add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
        }
        return result;
    }

}