package slidingwindow;

public class Introduction {

    public static void main(String[] args) {
        // Given an array, find the average of all contiguous subarrays of size ‘K’ in it
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        int n = arr.length;
        
        if(n < k) {
            System.out.println("Invalid Input");
            return;
        }

        double[] res = new double[n - k + 1];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            if(i >= k - 1) {
                res[i - k + 1] = (double) sum / k;
                sum -= arr[i - k + 1];
            }
        }

        for(int i = 0; i < n - k + 1; ++ i) {
            System.out.print(res[i] + " ");
        }
    }
}
