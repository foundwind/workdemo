package leecode;

public class Demo98 {
//

    public static void main(String[] args) {
    }


    Integer last = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            boolean validBST = isValidBST(root.left);
            if (!validBST) return false;
            if (last == null || root.val > last) {
                last = root.val;
            } else {
                return false;
            }
            boolean bst = isValidBST(root.right);
            return bst;
        }
    }

}