package slidingwindow;

// Given a binary array nums and an integer k,
// return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
public class LongestSubarrayWithOnesAfterReplacement {

    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0, start = 0, oneCount = 0;
        for(int end = 0; end < n; ++ end) {
            oneCount += nums[end];
            while (end - start + 1 > oneCount + k) {
                oneCount -= nums[start];
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static int longestOnesSingleLoop(int[] nums, int k) {
        int n = nums.length;
        int res = 0, start = 0, oneCount = 0;
        for(int end = 0; end < n; ++ end) {
            oneCount += nums[end];
            if (end - start + 1 > oneCount + k) {
                oneCount -= nums[start];
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));

        System.out.println(longestOnesSingleLoop(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnesSingleLoop(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
