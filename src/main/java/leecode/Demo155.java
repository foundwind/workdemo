package leecode;

public class Demo155 {
    public static void main(String[] args) {
    }

    class MinStack {


        int[] arr = new int[10000];
        int min = Integer.MAX_VALUE;
        int site = -1;

        public MinStack() {

        }

        public void push(int val) {
            min = Math.min(min, val);
            arr[++site] = val;
        }

        public void pop() {
            site--;
        }

        public int top() {
            return arr[site];
        }

        public int getMin() {
            return min;
        }
    }

}