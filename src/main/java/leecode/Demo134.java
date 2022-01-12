package leecode;

public class Demo134 {
//

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = cost.length;
        int start = -1;
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < len; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalCost > totalGas) return -1;
        // 采用倒车手法
        for (int i = 0; i < start + gas.length; i++) {
            // 判断当前是否能作为
            if (start == -1){

            }


        }

        return start;
    }

}