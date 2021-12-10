package leecode;

public class Demo91 {
//

    public static void main(String[] args) {

    }


    int count = 0;

    public int numDecodings(String s) {
        dfs(s.toCharArray(), 0, s.length());
        return count;
    }

    private void dfs(char[] chars, int start, int len) {




    }


}