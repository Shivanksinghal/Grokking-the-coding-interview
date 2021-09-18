package slidingwindow;

import java.util.Arrays;

/**
 * Leetcode - 567. Permutation in String (Medium)
 */
public class PermutationInString {

    /**
     * Time - O(s1 + s2 * 26) = O(26 * S2)
     * Space - O(26 * 2) = O(1)
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        int freqS1[] = new int[26];
        int freqS2[] = new int[26];

        s1.chars().forEach(c -> freqS1[c - 'a'] ++);
        int start = 0;

        for (int end = 0; end < s2.length(); ++end) {
            freqS2[s2.charAt(end) - 'a']++;
            if (end - start + 1 > s1.length()) {
                freqS2[s2.charAt(start) - 'a']--;
                start++;
            }
            if (Arrays.equals(freqS1, freqS2)) return true;
        }
        return false;
    }

    /**
     * Time - O(26 + s2) = O(s2)
     * Space - O(26 * 2) = O(1)
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusionOptimized(String s1, String s2) {
        int freqS1[] = new int[26];
        int freqS2[] = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            freqS1[s1.charAt(i) - 'a'] ++;
            freqS2[s2.charAt(i) - 'a'] ++;
        }
        int count = 0;
        for (int i = 0; i < 26; ++i) {
            if (freqS1[i] == freqS2[i])
                count ++;
        }

        for (int i = s1.length(); i < s2.length(); ++i) {
            if(count == 26) return true;
            int r = s2.charAt(i) - 'a';
            freqS2[r] ++;
            if (freqS1[r] == freqS2[r]) {
                count ++;
            } else if(freqS1[r] + 1 == freqS2[r]) {
                count --;
            }

            int l = s2.charAt(i - s1.length()) - 'a';
            freqS2[l] --;
            if (freqS1[l] == freqS2[l]) {
                count ++;
            } else if(freqS1[l] - 1 == freqS2[l]) {
                count --;
            }
        }
        return count == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));

        System.out.println(checkInclusionOptimized("ab", "eidbaooo"));
        System.out.println(checkInclusionOptimized("ab", "eidboaoo"));
    }
}
