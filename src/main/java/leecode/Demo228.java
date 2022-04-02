package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        if (nums.length == 1) return Arrays.asList(nums[0] + "");
        return null;
    }
}