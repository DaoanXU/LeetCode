package best_time_to_buy_and_sell_stock;

public class Solution {

    public int maxProfit(int[] prices) {
        int[] A = prices;
        if (A.length < 2)
            return 0;

        int buy = 0;
        int sell = 1;
        int max = Math.max(A[sell] - A[buy], 0);
        while (sell < A.length) {
            max = Math.max(A[sell] - A[buy], max);
            if (A[sell] < A[buy])
                buy = sell;
            sell++;
        }

        return max;
    }

}
