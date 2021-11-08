package leecode;

import java.math.BigDecimal;

public class Demo60 {
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
//按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//    "123"
//    "132"
//    "213"
//    "231"
//    "312"
//    "321"
//
//给定 n 和 k，返回第 k 个排列。
//

    public static void main(String[] args) {
        String price = "8.00 ";
        price = price.trim();
        System.out.println(new BigDecimal(price).toEngineeringString());
        System.out.println(new Demo60().getPermutation(3, 2));
    }


    boolean[] used;
    char[] chars;

    int maxN;

    public String getPermutation(int n, int k) {
        maxN = n;
        chars = new char[n];
        used = new boolean[n];
        int total = 1;
        for (int i = 1; i < n; i++) {
            total *= i;
        }
        round(total, n, k);
        return new String(chars);
    }

    private void round(int total, int n, int k) {
        if (n == 1) {
            int index = 0;
            while (used[index] == true) {
                index++;
            }
            chars[index] = (char) (index + 1 + '0');
            return;
        }

        int num = (k - 1) / total + 1;

        int cacheNum = 0;
        int index = 0;
        for (int i = 0; i < maxN; i++) {
            if (used[i] == false){
                cacheNum ++;
                if (cacheNum == num){
                    index = i;
                    used[i] = true;
                    break;
                }
            }
        }
        chars[index] = (char) (index + 1 + '0');
        int next = n - 1;
        while (k > total) {
            k -= total;
        }
        int nextTotal = total / next;

        round(nextTotal, next, k);
    }
}