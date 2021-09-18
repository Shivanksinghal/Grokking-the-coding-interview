package slidingwindow;

public class LongestSubstringWithSameLettersAfterReplacement {

    public static int characterReplacement(String s, int k) {
        int start = 0, res = 0, n = s.length(), maxFreq = 0;;
        int f[] = new int[26];
        for(int end = 0; end < n; ++end) {
            char currentChar = s.charAt(end);
            f[currentChar - 'A'] ++;
            maxFreq = Math.max(maxFreq, f[currentChar - 'A']);
            while(end - start + 1 > maxFreq + k) {
                f[s.charAt(start) - 'A'] --;
                start ++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
