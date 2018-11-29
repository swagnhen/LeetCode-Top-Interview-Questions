package pers.swegnhan.leetcode.easy.array;

public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int profit = 0, day = 0;
        while(day < prices.length){
            while(day + 1 < prices.length && prices[day] >= prices[day + 1])
                day++;
            if(day == prices.length - 1)
                break;
            profit -= prices[day];
            while(day + 1 < prices.length && prices[day] <= prices[day + 1])
                day++;
            profit += prices[day];
        }
        return profit;
    }

    public static void main(String[] args){
        System.out.println(maxProfit(new int []{7,6,4,3,1}));
    }

}
