package leecode;

public class Demo135 {
//

    public static void main(String[] args) {
        System.out.println(new Demo135().candy(new int[]{1, 2, 3, 1, 0}));
    }

    public int candy(int[] ratings) {
        int total = 1;
        int nowCount = 1;
        int[] score = new int[ratings.length];
        score[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            // 如果右边比左边大
            if (ratings[i] > ratings[i - 1]) {
                nowCount++;
                score[i] = nowCount;
                total += nowCount;
            } else if (ratings[i] == ratings[i - 1]) {
                // 如果右边和左边一样大
                nowCount = 1;
                score[i] = nowCount;
                total += 1;
            } else {
                // 如果右边比左边小
                if (nowCount == 1) {
                    // 右边已经不能再进行处理了，需要往左找
                    score[i] = nowCount;
                    for (int j = i; j > 0; j--) {
                        if (ratings[j - 1] > ratings[j] && score[j - 1] <= score[j]) {
                            score[j - 1] += 1;
                            total++;
                        } else {
                            break;
                        }
                    }
                    total += 1;
                } else {
                    nowCount = 1;
                    score[i] = nowCount;
                    total += 1;
                }
            }
        }
        return total;
    }

}