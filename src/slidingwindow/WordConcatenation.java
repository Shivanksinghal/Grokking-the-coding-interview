package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leet Code - 30. Substring with Concatenation of All Words (Hard)
 */
public class WordConcatenation {

    /**
     * Time - O(s * w)
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        int wordLength = words[0].length();
        if (words.length * wordLength > s.length()) return res;

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for (int j = 0; j < wordLength; ++j) {
            Map<String, Integer> strMap = new HashMap<>();
            for (int i = j; i < wordLength * words.length + j; i += wordLength) {
                String subStr = s.substring(i, i + ((s.length() - i > wordLength) ? wordLength : s.length() - i));
                strMap.put(subStr, strMap.getOrDefault(subStr, 0) + 1);
            }
            if (strMap.equals(wordsMap)) {
                res.add(j);
            }
            int start = j;
            for (int i = wordLength * words.length + j; i < s.length(); i += wordLength) {
                String subStr = s.substring(i, i + ((s.length() - i > wordLength) ? wordLength : s.length() - i));
                strMap.put(subStr, strMap.getOrDefault(subStr, 0) + 1);
                String startStr = s.substring(start, start + wordLength);
                start += wordLength;
                if (strMap.get(startStr) == 1) {
                    strMap.remove(startStr);
                } else {
                    strMap.put(startStr, strMap.get(startStr) - 1);
                }
                if (strMap.equals(wordsMap)) {
                    res.add(start);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
    }
}
