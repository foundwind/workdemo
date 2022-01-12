package leecode;

public class Demo150 {
    public static void main(String[] args) {
        System.out.println(new Demo150().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    int pos;

    public int evalRPN(String[] tokens) {
        pos = tokens.length - 1;
        return dfs(tokens);
    }

    private int dfs(String[] tokens) {
        int site = pos;
        pos--;
        switch (tokens[site]) {
            case "+":
                return dfs(tokens) + dfs(tokens);
            case "-":
                int right = dfs(tokens);
                return dfs(tokens) - right;
            case "*":
                return dfs(tokens) * dfs(tokens);
            case "/":
                int right2 = dfs(tokens);
                return dfs(tokens) / right2;
            default:
                return Integer.valueOf(tokens[site]);
        }
    }

}