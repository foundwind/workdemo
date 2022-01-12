package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo120 {
//

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(new int[]{2}).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(new int[]{3, 4}).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(new int[]{6, 5, 7}).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(new int[]{4, 1, 8, 3}).boxed().collect(Collectors.toList()));
        System.out.println(new Demo120().minimumTotal(list));
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] cache = new int[len+1];
        bp(cache,triangle,len-1);
        return cache[0];
    }
    public void bp(int[] cache,List<List<Integer>> triangle, int i){
        if(i >= 0){
            List<Integer> list = triangle.get(i);
            for(int j = 0 ; j <= i; j++){
                cache[j] = list.get(j) + Math.min(cache[j],cache[j+1]);
            }
        }else{
            return;
        }
        bp(cache,triangle,i-1);
    }

}