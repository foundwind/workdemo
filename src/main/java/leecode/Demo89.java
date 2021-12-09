package leecode;

import java.util.ArrayList;
import java.util.List;

public class Demo89 {
//

    public static void main(String[] args) {
        new Demo89().grayCode(2);
        new Demo89().grayCode2(2);
    }

    List<Integer> res;
    int last;

    public List<Integer> grayCode(int n) {
        // 长度
        int[] pow = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};
        int len = pow[n];

        // 最终result
        res = new ArrayList<>(len);
        res.add(0);
        last = 0;
        dsf(len - 2, n - 1);
        return res;
    }

    void dsf(int right, int n) {
        if (right == 0) {
            last = last ^ 0b1;
            res.add(last);
            return;
        }
        int mid = (right) >> 1;
        dsf(mid - 1, n - 1);
        last = last ^ (1 << n);
        res.add(last);
        dsf(mid - 1, n - 1);
    }

    public List<Integer> grayCode2(int n) {
        // 第0位格雷码
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        // 首位
        int head = 1;
        for (int i = 0; i < n; i++) {

            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }

}