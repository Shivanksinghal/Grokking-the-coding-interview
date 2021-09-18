package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public static int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            Map<Character, Boolean> map = new HashMap<>();
            int len = 0;
            for (int j = i; j < n; ++j) {
                if (map.containsKey(s.charAt(j))) break;
                map.put(s.charAt(j), true);
                len ++;
            }
            res = Math.max(res, len);
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> characterMap = new HashMap<>();
        int res = 0, start = 0;
        for(int end = 0; end < n; ++end) {
            if(characterMap.getOrDefault(s.charAt(end), -1) != -1) {
                start = Math.max(start, characterMap.get(s.charAt(end)) + 1);
            }
            characterMap.put(s.charAt(end), end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        assert lengthOfLongestSubstring("abcabcbb") == 3;
        assert lengthOfLongestSubstring("bbbbb") == 1;
        assert lengthOfLongestSubstring("pwwkew") == 3;
        assert lengthOfLongestSubstring("") == 0;
    }
}
