package best_time_to_buy_and_sell_stock_ii;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] A = prices;
        if (A.length < 2)
            return 0;

        int max = 0;
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            max = diff > 0 ? max + diff : max;
        }
        return max;
    }

}
