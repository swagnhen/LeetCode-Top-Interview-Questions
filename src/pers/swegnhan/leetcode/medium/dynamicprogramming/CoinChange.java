package pers.swegnhan.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinChangeStep(coins, amount, coins.length - 1, 0);
    }

    public static int coinChangeStep(int[] coins, int amount, int end, int count){
        if(amount == 0)
            return count;
        if(amount < 0 || end < 0)
            return -1;
        int result1 = -1, result2 = -1;
        result1 = coinChangeStep(coins, amount - coins[end], end, count + 1);
        result2 = coinChangeStep(coins, amount, end - 1, count);
        if(result1 != -1 && result2 != -1)
            return Math.min(result1, result2);
        else
            return Math.max(result1, result2);
    }

    public static int coinChangePlus(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] == 0)
                    dp[i] = 1;
                if(i - coins[j] > 0 && dp[i - coins[j]] > 0)
                    if(dp[i] != 0)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    else
                        dp[i] = dp[i - coins[j]] + 1;
            }
        }
        if(dp[amount] == 0)
            return -1;
        return dp[amount];
    }

    public static void main(String[] args){
        System.out.println(coinChangePlus(new int[]{186,419,83,408}, 6249));
    }

}
