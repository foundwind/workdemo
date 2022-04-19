package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo350 {
//

    public static void main(String[] args) {
        new Demo350().intersect(new int[]{4, 9, 5}
                ,
                new int[]{
                        9, 4, 9, 8, 4
                });
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i : nums1) {
            Integer integer = map.getOrDefault(i, 0);
            map.put(i, integer + 1);
        }
        for (int i : nums2) {
            Integer integer = map.getOrDefault(i, 0);
            if (integer != 0) {
                list.add(i);
                map.put(i, integer - 1);
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }


}
