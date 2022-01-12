package leecode;

import java.util.HashMap;
import java.util.Map;

public class Demo137 {
//

    public static void main(String[] args) {
        System.out.println(new Demo137().singleNumber(new int[]{1, 1, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            Integer integer = map.getOrDefault(num, 0) + 1;
            // 已经进来了第三次
            if (integer == 3) {
                result = result ^ num;
            } else if (integer == 1) { // 第一次进来
                result = result ^ num;
                map.put(num, integer);
            } else {
                map.put(num, integer);
            }
        }
        return result;
    }
}