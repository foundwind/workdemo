package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo212 {

    public static void main(String[] args) {
        new Demo212().findWords(null, new String[]{"are", "string", "ok", "aret", "areb"});
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    Set<String> result = new HashSet<>();
    WordBook book = new WordBook();
    int yLen;
    int xLen;

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            putWord(word);
        }
        yLen = board.length;
        xLen = board[0].length;
        for (int i = 0; i < yLen; i++) {
            for (int j = 0; j < xLen; j++) {
                round(board, i, j, book);
            }
        }

        return new ArrayList<>(result);
    }

    private void round(char[][] board, int y, int x, WordBook book) {
        WordBook nextBook = book.cacheMap.get(board[y][x]);
        if (nextBook == null) {
            return;
        }
        char ch = board[y][x];
        if (!"".equals(nextBook.word)) {
            result.add(nextBook.word);
            nextBook.word = "";
        }
        if (!nextBook.cacheMap.isEmpty()) {
            board[y][x] = '~';
            // 往四周去寻找
            for (int[] dir : dirs) {
                int y2 = y + dir[0], x2 = x + dir[1];
                if (y2 >= 0 && y2 < yLen && x2 >= 0 && x2 < xLen) {
                    round(board, y2, x2, nextBook);
                }
            }
            board[y][x] = ch;
        } else { // 已经找到过了没必须要继续找
            book.cacheMap.remove(ch);
        }

    }

    private void putWord(String word) {
        WordBook midBook = book;
        for (int i = 0; i < word.length(); i++) {
            WordBook wordBook = midBook.cacheMap.get(word.charAt(i));
            if (wordBook == null) {
                wordBook = new WordBook();
                midBook.cacheMap.put(word.charAt(i), wordBook);
            }
            midBook = wordBook;
        }
        midBook.word = word;
    }

    public class WordBook {
        public String word = "";
        public Map<Character, WordBook> cacheMap = new HashMap<>();
    }


}