package leecode;

public class Demo165 {
    public static void main(String[] args) {
        System.out.println(new Demo165().compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len1 = split1.length;
        int len2 = split2.length;
        int min = Math.min(len1, len2);
        int max = Math.max(len1, len2);
        for (int i = 0; i < min; i++) {
            if (Integer.valueOf(split1[i]) > Integer.valueOf(split2[i])) {
                return 1;
            }
            if (Integer.valueOf(split1[i]) < Integer.valueOf(split2[i])) {
                return -1;
            }
        }
        if (len1 == len2) return 0;
        String[] check;
        if (len1 > len2) {
            check = split1;
        } else {
            check = split2;
        }
        for (int i = min; i < max; i++) {
            if (Integer.valueOf(check[i]) != 0) {
                if (len1 > len2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

}