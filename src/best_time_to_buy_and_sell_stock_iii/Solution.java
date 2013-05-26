package best_time_to_buy_and_sell_stock_iii;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] A = prices;
        if (A.length < 2)
            return 0;

        int[] firstHalf = new int[A.length];
        int[] secondHalf = new int[A.length];

        firstHalf[0] = 0;
        secondHalf[A.length - 1] = 0;

        int buy;
        int sell;
        int max;

        buy = 0;
        sell = 1;
        max = Math.max(A[sell] - A[buy], 0);
        while (sell < A.length) {
            max = Math.max(A[sell] - A[buy], max);
            firstHalf[sell] = max;
            if (A[sell] < A[buy])
                buy = sell;
            sell++;
        }

        buy = A.length - 2;
        sell = A.length - 1;
        max = Math.max(A[sell] - A[buy], 0);
        while (buy > -1) {
            max = Math.max(A[sell] - A[buy], max);
            secondHalf[buy] = max;
            if (A[sell] < A[buy])
                sell = buy;
            buy--;
        }

        max = 0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, firstHalf[i] + secondHalf[i]);
        }

        return max;

    }
}
