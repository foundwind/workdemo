package leecode;

import java.util.*;

public class Demo39 {
//输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//
//示例 2：
//
//输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/combination-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
//        List<List<Integer>> lists = new Demo39().combinationSum(new int[]{2, 3, 5}, 8);
        List<List<Integer>> lists = new Demo39().combinationSum(new int[]{2, 3, 6,7}, 7);
        System.out.println(lists);
    }

    ArrayList<List<Integer>> result = new ArrayList<>();
    int length = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
        length = candidates.length;

        round(0, candidates, target, new ArrayList<>());
        return result;
    }

    private void round(int index, int[] candidates, int target, List<Integer> list) {
        if (index == length) return;
        int num = candidates[index];
        int initSize = list.size();
        if (num > target) {
            return;
        }
        if (num == target) {
            list.add(num);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        // 自己叠加n次，或者少次
        if (target % num == 0) {
            int time = target / num;
            for (int i = 0; i < time; i++) {
                list.add(num);
            }
            result.add(new ArrayList<>(list));
            clearList(initSize, list);
        }
        int time = target / num;
        for (int i = 1; i < time; i++) {
            for (int j = 0; j < i; j++) {
                list.add(num);
            }
            round(index + 1, candidates, target - num * i, list);
            clearList(initSize, list);
        }
        // 不加
        round(index + 1, candidates, target, list);

    }

    private void clearList(int initSize, List<Integer> list) {
        int now = list.size();
        for (int i = now; i > initSize; i--) {
            list.remove(i - 1);
        }
    }

}