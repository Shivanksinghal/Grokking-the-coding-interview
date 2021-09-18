package slidingwindow;

public class MaximumSumSubarrayOfSizeK {

    public static int maximumSumSubarrayOfSizeK(int arr[], int k) {
        int n = arr.length;

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            if(i >= k - 1) {
                res = Math.max(res, sum);
                sum -= arr[i - k + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        int res1 = maximumSumSubarrayOfSizeK(arr1, k1);
        System.out.println(res1);

        int arr2[] = {2, 3, 4, 1, 5};
        int k2 = 2;
        int res2 = maximumSumSubarrayOfSizeK(arr2, k2);
        System.out.println(res2);
    }
}
