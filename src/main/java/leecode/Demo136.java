package leecode;

public class Demo136 {
//

    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }

}