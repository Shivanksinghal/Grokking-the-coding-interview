package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n == 0)
            return 0;
        int res = 0, start = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < n; ++end) {
            int curFruit = fruits[end];
            int curFruitCount = map.getOrDefault(curFruit, 0);
            map.put(curFruit, curFruitCount + 1);
            while (map.size() > 2 && start < n) {
                int startFruit = fruits[start];
                int startFruitCount = map.getOrDefault(startFruit, 1) - 1;
                if(startFruitCount != 0) {
                    map.put(startFruit, startFruitCount);
                } else {
                    map.remove(startFruit);
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        assert totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}) == 5;
    }
}
