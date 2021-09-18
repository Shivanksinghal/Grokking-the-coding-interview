package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode - 438. Find All Anagrams in a String (Medium)
 */
public class StringAnagrams {

    /**
     * Time - O(p + 26 * (s - p)) = O(26 * S)
     * Space - O(26 * 2 = O(1)
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int fs[] = new int[26];
        int fp[] = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            fs[s.charAt(i) - 'a'] ++;
            fp[p.charAt(i) - 'a'] ++;
        }
        for (int i = p.length(); i < s.length(); ++i) {
            if (Arrays.equals(fs, fp)) {
                res.add(i - p.length());
            }
            fs[s.charAt(i) - 'a'] ++;
            fs[s.charAt(i - p.length()) - 'a'] --;
        }
        if (Arrays.equals(fs, fp))
            res.add(s.length() - p.length());
        return res;
    }

    /**
     * Time - O(26 + s) = O(s)
     * Space - O(26 * 2) = O(1)
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagramsOptimized(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int fs[] = new int[26];
        int fp[] = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            fs[s.charAt(i) - 'a'] ++;
            fp[p.charAt(i) - 'a'] ++;
        }
        int count = 0;
        for (int i = 0; i < 26; ++i) {
            if (fs[i] == fp[i])
                count ++;
        }
        for (int i = p.length(); i < s.length(); ++i) {
            int start = s.charAt(i - p.length()) - 'a';
            int end = s.charAt(i) - 'a';
            if (count == 26) res.add(i - p.length());

            fs[end] ++;
            if (fs[end] == fp[end]) count ++;
            else if(fs[end] == fp[end] + 1) count --;

            fs[start] --;
            if (fs[start] == fp[start]) count ++;
            else if(fs[start] == fp[start] - 1) count --;
        }
        if (count == 26)
            res.add(s.length() - p.length());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));

        System.out.println(findAnagramsOptimized("cbaebabacd", "abc"));
        System.out.println(findAnagramsOptimized("abab", "ab"));
    }
}
