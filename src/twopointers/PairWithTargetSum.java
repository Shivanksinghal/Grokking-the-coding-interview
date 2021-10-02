package twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode - 1. Two Sum (Easy)
 */
public class PairWithTargetSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[] {2, 7, 11, 15}, 9)).forEach((a) -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(twoSum(new int[]{3,2,4}, 6)).forEach((a) -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(twoSum(new int[]{3,3}, 6)).forEach((a) -> System.out.print(a + " "));
        System.out.println();
    }
}
