package leecode;

import java.util.HashMap;
import java.util.Map;

public class Demo146 {

    class LRUCache {
        // 当前的尾部
        private int nowSize = 0;
        private int capacity;
        // 位置Map
        private Map<Integer, Integer> pointMap = new HashMap<>();
        private int[] keyArr;
        private int[] valueArr;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keyArr = new int[capacity];
            valueArr = new int[capacity];
        }

        public int get(int key) {
            Integer index = pointMap.get(key);
            if (index == null) return -1;
            if (keyArr[index] != key) return -1;
            return valueArr[index];
        }

        public void put(int key, int value) {
            // 当前数据量已经满了
            if (nowSize == capacity) {
                // 判断当前是否有这个key
                Integer index = pointMap.get(key);
                if (index != null && keyArr[index] == key) { // 需要把自己搬移到最后

                } else { // 需要去除掉0


                }
            } else {
                keyArr[nowSize] = key;
                valueArr[nowSize] = value;
                pointMap.put(key, nowSize);
                nowSize++;
            }
        }
    }
}