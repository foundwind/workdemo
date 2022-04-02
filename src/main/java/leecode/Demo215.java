import java.util.Random;

public class Demo215 extends ClassLoader{
    Random random = new Random();





    Integer check = null;
    private Demo215 ff = null;

    public Demo215() {
        check = 1;
    }

    public Demo215 getFf() {
        return ff;
    }

    public void setFf(Demo215 ff) {
        this.ff = ff;
    }

    public static void main(String[] args) {
        Demo215 test = new Demo215();
        new Thread(() -> {
            init(test);
            while (true) {
                if (test.getFf() != null) {
                    if (test.ff.check == 0) {
                        System.out.println("你好");
                        break;
                    } else {
                        System.out.println("1");
                        break;
                    }
                }
            }
        }).start();

    }

    private static void init(Demo215 test) {
        new Thread(() -> {
            test.setFf(new Demo215());
        }).start();
        ;
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
