package leecode;

public class Demo75 {
//

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    one++;
                    break;
                case 1:
                    two++;
                    break;
                case 2:
                    three++;

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (one != 0) {
                nums[i] = 0;
                one--;
            } else if (two != 0) {
                nums[i] = 1;
                two--;
            } else {
                nums[i] = 2;
                three--;
            }
        }
    }

}