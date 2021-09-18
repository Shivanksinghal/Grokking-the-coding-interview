package slidingwindow;

/**
 * Leetcode - 76. Minimum Window Substring (Hard)
 */
public class SmallestWindowContainingSubstring {

    private static boolean matches(int[] hashPat, int[] hashStr) {
        boolean flag = true;
        for (int j = 0; j < 255; ++j) {
            if (hashPat[j] > hashStr[j]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * Time - O(t + 255 + 255*(S-t)) = O(S * 255)
     * Space - O(255 * 2) = O(1)
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int hashPat[] = new int[255];
        int hashStr[] = new int[255];
        for (int i = 0; i < t.length(); ++i) {
            hashPat[t.charAt(i)] ++;
            hashStr[s.charAt(i)] ++;
        }
        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0, minEnd = 0;
        if (matches(hashPat, hashStr)) {
            return s.substring(0, t.length());
        }
        for (int i = t.length(); i < s.length(); ++ i) {
            hashStr[s.charAt(i)] ++;
            while (start < s.length() && hashStr[s.charAt(start)] > hashPat[s.charAt(start)]) {
                hashStr[s.charAt(start)] --;
                start ++;
            }
            if (matches(hashPat, hashStr) && i - start + 1 < minLen) {
                minLen = i - start + 1;
                minStart = start;
                minEnd = i + 1;
            }
        }
        return s.substring(minStart, minEnd);
    }

    /**
     * Time - O(255 + S) = O(S)
     * Space - O(255 * 2) = O(1)
     * @param s
     * @param t
     * @return
     */
    public static String minWindowOptimized(String s, String t) {
        if (t.length() > s.length()) return "";
        int hashPat[] = new int[255];
        int hashStr[] = new int[255];
        int count = 0;
        for (int i = 0; i < t.length(); ++i) {
            hashPat[t.charAt(i)] ++;
            hashStr[s.charAt(i)] ++;
        }
        for (int i = 0; i < 255; ++i) {
            count += (hashPat[i] <= hashStr[i]) ? 1 : 0;
        }
        int start = 0, minLen = Integer.MAX_VALUE, minStart = 0, minEnd = 0;

        if (count == 255) return s.substring(0, t.length());
        for (int i = t.length(); i < s.length(); ++ i) {
            hashStr[s.charAt(i)] ++;
            if (hashStr[s.charAt(i)] == hashPat[s.charAt(i)]) count ++;
            while (start < s.length() && hashStr[s.charAt(start)] > hashPat[s.charAt(start)]) {
                hashStr[s.charAt(start)] --;
                if (hashPat[s.charAt(start)] > hashStr[s.charAt(start)]) count --;
                start ++;
            }
            if (count == 255 && i - start + 1 < minLen) {
                minLen = i - start + 1;
                minStart = start;
                minEnd = i + 1;
            }
        }
        return s.substring(minStart, minEnd);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));

        System.out.println(minWindow("AB", "a"));


        System.out.println(minWindowOptimized("ADOBECODEBANC", "ABC"));
    }
}
