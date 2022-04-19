package leecode;

public class Demo344 {
//

    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char cache = s[left];
            s[left] = s[right];
            s[right] = cache;
            left++;
            right--;
        }
    }

}
