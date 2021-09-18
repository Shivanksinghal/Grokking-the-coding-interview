package slidingwindow;


import java.util.HashMap;
import java.util.Map;

public class SmallestSubarrayWithGivenSum {

    // FOR POSITIVE INTEGERS ONLY
    // Time: O(n), Space: O(1)
    public static int smallestSubarrayWithGivenSum(int arr[], int s) {
        int n = arr.length;
        int res = Integer.MAX_VALUE, sum = 0, start = 0;
        for (int end = 0; end < n; ++end) {
            sum += arr[end];
            while(sum > s) {
                sum -= arr[start];
                start ++;
            }
            if(sum == s) {
                res = Math.min(res, end - start + 1);
            }
        }
        return res;
    }

    // For Both Positive and negative integers
    // using hashmap (Time: O(n), Space: O(n))
    public static int smallestSubarrayWithGivenSumForBothPositiveAndNegative(int arr[], int s) {
        int n = arr.length;
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            // s == sum + arr[i] -----> map.get(s - arr[i])
            sum += arr[i];
            if(map.getOrDefault(sum - s, -1) != -1) {
                res = Math.min(res, i - map.get(sum - s));
            }
            map.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 2, 3, 2};
        int s = 7;
        System.out.println(smallestSubarrayWithGivenSum(arr, s));
        System.out.println(smallestSubarrayWithGivenSumForBothPositiveAndNegative(arr, s));
        // i = 0, false, sum = 2, map = {2=0};
        // i = 1, false, sum = 3, map = {2=0, 3=1}
        // i = 2, sum = 8, false, map = {2=0, 3=1, 8=2}
        // i = 3, sum = 10, true, res =...

        int arr2[] = {2, 1, 5, 2, 8};
        int s2 = 7;
        System.out.println(smallestSubarrayWithGivenSum(arr2, s2));
        System.out.println(smallestSubarrayWithGivenSumForBothPositiveAndNegative(arr2, s2));

        // int arr3[] = {1, 2, 4, -2, 1};
        // int sum = 5;

    }
}
