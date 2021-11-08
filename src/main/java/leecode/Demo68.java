package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo68 {
//

    public static void main(String[] args) {
//        new Demo68().fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16);
        new Demo68().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        new Demo68().fullJustify(new String[]{"a"}, 1);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        if (len == 1) {
            StringBuilder builder = new StringBuilder();
            builder.append(words[0]);
            int blankNum = maxWidth - words[0].length();
            for (int k = 0; k < blankNum; k++) {
                builder.append(" ");
            }
            return Arrays.asList(builder.toString());
        }

        List<String> result = new ArrayList<>();
        List<Integer> cache = new ArrayList<>();

        int index = 0;
        int size = 0;
        while (index < len) {
            if (size + words[index].length() > maxWidth) {
                // 超出范围了 ,记录一下单词
                cache.add(index);
                size = 0;
            } else {
                size = size + 1 + words[index].length();
                index++;
            }
        }
        for (int i = 0; i < cache.size(); i++) {
            int left = 0;
            int right = cache.get(i);

            if (i > 0) {
                left = cache.get(i - 1);
            }
            // 间距
            int spilt = right - left - 1;
            StringBuilder builder = new StringBuilder();
            if (spilt != 0) {
                int blankNum = maxWidth;
                boolean round = false;
                for (int j = left; j < right; j++) {
                    blankNum = blankNum - words[j].length();
                }

                int more = blankNum % spilt;
                if (more != 0) {
                    round = true;
                }
                blankNum = blankNum / spilt;


                for (int j = left; j < right; j++) {
                    builder.append(words[j]);
                    if (j != right - 1) {
                        if (j != right - 2 && round && more-- > 0) {
                            for (int k = 0; k < blankNum + 1; k++) {
                                builder.append(" ");
                            }
                        } else {
                            for (int k = 0; k < blankNum; k++) {
                                builder.append(" ");
                            }
                        }
                    }
                }
            } else {
                int blankNum = maxWidth - words[left].length();
                builder.append(words[left]);
                for (int k = 0; k < blankNum; k++) {
                    builder.append(" ");
                }
            }
            result.add(builder.toString());
        }

        // 最后一行
        Integer lastIndex = cache.get(cache.size() - 1);
        StringBuilder builder = new StringBuilder();
        for (int i = lastIndex; i < len; i++) {
            builder.append(words[i]);
            if (i != len - 1) {
                builder.append(" ");
            }
        }
        while (builder.length() < maxWidth) {
            builder.append(" ");
        }
        result.add(builder.toString());
        return result;
    }

}
