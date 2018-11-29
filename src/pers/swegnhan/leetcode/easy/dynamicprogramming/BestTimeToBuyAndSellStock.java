package pers.swegnhan.leetcode.easy.dynamicprogramming;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i++)
            for (int j = i; j < prices.length; j++)
                max = Math.max(max, prices[j] - prices[i]);
        return max;
    }

    public static int maxProfitPlus(int[] prices) {
        if(prices.length == 0)
            return 0;
        int max  = 0, sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(sum < 0)
                sum = prices[i] - prices[i - 1];
            else
                sum += prices[i] - prices[i - 1];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(maxProfitPlus(new int[]{7,1,5,3,6,4}));
    }

}
