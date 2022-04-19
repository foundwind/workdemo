package leecode;

import java.util.HashMap;
import java.util.Map;

public class Demo337 {
//

    public static void main(String[] args) {
    }

    public Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.get(root) != null) {
            return map.get(root);
        }

        // 如果抢劫当前的房子
        int now = root.val;
        if (root.right != null) {
            now += rob(root.right.right) + rob(root.right.left);
        }
        if (root.left != null) {
            now += rob(root.left.right) + rob(root.left.left);
        }
        int max = Math.max(now, rob(root.left) + rob(root.right));
        map.put(root, max);
        return max;
    }


}
