package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo49 {
//

    public static void main(String[] args) {
        new Demo49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

        public List<List<String>> groupAnagrams(String[] strs) {
            int len = strs.length;
            Map<String, Integer> resultMap = new HashMap<>();
            List<List<String>> result = new ArrayList<>();
            int index = 0;
            for (int i = 0; i < len; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                if (resultMap.containsKey(key)) {
                    result.get(resultMap.get(key)).add(strs[i]);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    result.add(list);
                    resultMap.put(key, index++);
                }
            }

            return result;
        }
}