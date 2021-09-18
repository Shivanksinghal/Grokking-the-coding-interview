package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaximumKDistinctCharacters {

    // Time: O(n+n), Space: O(k)
    public static int longestSubstringWithMaximumKDistinctCharacters(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, curNoOfCharacters = 0, start = 0;
        for (int i = 0; i < str.length(); ++i) {
            char currentChar = str.charAt(i);
            int currentFreq = map.getOrDefault(currentChar, 0);
            if(currentFreq == 0) {
                curNoOfCharacters ++;
            }
            map.put(currentChar, currentFreq + 1);
            while(curNoOfCharacters > k) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if(map.get(startChar) == 0) {
                    map.remove(startChar);
                    curNoOfCharacters --;
                }
                start ++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String str1 = "araaci";
        int k1 = 2;
        System.out.println(longestSubstringWithMaximumKDistinctCharacters(str1, k1));

        String str2 = "araaci";
        int k2 = 1;
        System.out.println(longestSubstringWithMaximumKDistinctCharacters(str2, k2));

        String str3 = "cbbebi";
        int k3 = 3;
        System.out.println(longestSubstringWithMaximumKDistinctCharacters(str3, k3));

        String str4 = "cbbebi";
        str1.chars().distinct().count();
        int k4 = 10;
        System.out.println(longestSubstringWithMaximumKDistinctCharacters(str4, k4));
    }
}
