# LeetCode便签

## Linked List Cycle

### 问题描述

Given a linked list, determine if it has a cycle in it.

Follow up:Can you solve it without using extra space?

### 解决思路

声明一个慢指针和一个快指针

慢指针一次后移一个节点，快指针一次后移两个节点

不断后移至指针指空，或两指针相遇

### 代码

``` java
public boolean hasCycle(ListNode head) {
    if(head==null) return false;
    ListNode walker = head;
    ListNode runner = head;
    while(runner.next!=null && runner.next.next!=null) {
        walker = walker.next;
        runner = runner.next.next;
        if(walker==runner) return true;
    }
    return false;
}
```

## Merge Sorted Array

### 问题描述

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

+ The number of elements initialized in nums1 and nums2 are m and n respectively.
+ You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

### 解决思路

与一般的合并有序串思路相同

关键点在于从高向地合并便可以既不需要新的空间又回避需要暂时num1中元素问题

### 代码

``` java
public void mergePlus(int[] nums1, int m, int[] nums2, int n){
    int p1 = m - 1, p2 = n - 1, p3 = m + n -1;
    while(p1 >= 0 && p2 >= 0){
        if(nums1[p1] >= nums2[p2])
            nums1[p3--] = nums1[p1--];
        else
            nums1[p3--] = nums2[p2--];
    }
    while(p1 >= 0)
        nums1[p3--] = nums1[p1--];
    while(p2 >= 0)
        nums1[p3--] = nums2[p2--];
}
```

## Best Time to Buy and Sell Stock

### 问题描述

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

### 解决思路

常规解法是用一个变量记录最低价一个变量记录最大差价迭代至结束。

如果对输入的每日股价数组做一些处理，将其变为每日股价变化即两日间股价的差价，这个问题便变成了最大子序列和问题，可用Kadane's算法解决。

### 代码

``` java
public int maxProfit (int[] prices) {
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
```

## Min Stack

### 问题描述

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

+ push(x) -- Push element x onto stack.
+ pop() -- Removes the element on top of the stack.
+ top() -- Get the top element.
+ getMin() -- Retrieve the minimum element in the stack.

### 解决思路

若想将getMin()的复杂度控制在O(1)，栈中数据必须携带额外信息，这种时候加减往往能产生意料之外的效果。

栈中保存一个用于记录最小值的数据成员。每次入栈时，都先将新值与当前最小值的差值插入栈中，然后若新值小于最小值，则新值成为新的最小值。

这种处理方式的优势在于记录了最小值的变化信息，若栈顶元素为负数，则说明当前元素比上一个局部最小值小，并可以通过将当前最小值与栈顶元素相减的方式还原出上一层次最小值。

### 代码

```java
class MinStack {
    
    class StackNode{

        public StackNode(long x) { val = x; }

        public long val;

        public StackNode next;

    }

    private int size = 0;

    private long min = Integer.MAX_VALUE;

    private StackNode head = new StackNode(0);

    /** initialize your data structure here. */
    public MinStack() {}

    public void push(int x) {
        StackNode newNode = null;
        if(size == 0)
            newNode = new StackNode(0);
        else
            newNode = new StackNode((long)x - min);
        if(x < min)
            min = x;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void pop() {
        if(size == 0)
            return;
        if(head.val < 0)
            min = min - head.val;
        head = head.next;
        size--;
        if(size == 0)
            min = Integer.MAX_VALUE;
    }

    public int top() {
        if(head.val < 0)
            return (int)min;
        return (int)(head.val + min);
    }

    public int getMin() {
        return (int)min;
    }

}
```

## Count Primes

### 问题描述

Count the number of prime numbers less than a non-negative number, n.

### 解决思路

一开始的思路为，先创建一个保存已发现质数的容器，从2开始寻找，每个被测试数字都与容器内的所有元素做除法取余操作，若都不为0，则这个数字为新的质数。

这种思路正确性没有问题，但是会超时。即使去掉一开始使用的List容器也依然存在超时问题。故严重的耗时可能是由于除法产生的。

故新的思路为创建一个长为n的boolean类型数组，每一位表示该该下表对应的元素是否为不是质数，初始值所有元素都是质数。再循环中让元素与每个大于等于他的元素相乘，并将数组里乘机结果位置的元素改为不是质数。用乘法代替除法使效率得到提升。

### 代码

``` java
public static int countPrimes(int n) {
    boolean[] isNotPrimes = new boolean[n];
    int count = 0;
    for(long i = 2; i < n; i++){
        if(isNotPrimes[(int)i] == false)
            count++;
        for(long j = i; i * j < n; j++)
            isNotPrimes[(int)(i * j)] = true;
    }
    return count;
}
```

## Number of 1 Bits

### 问题描述

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

### 解决思路

常规解法都能在O(n)时间内求得解，技巧性强一点的可在O(m)时间内结束，m表示1的个数。

O(m)的解法思路在于计算输入数字n变为零之前执行n = (n - 1) & n的次数，这句的精巧之处在于可以一次翻转所有末尾的0位，使下一个1的位置直接暴露出来。

还有一点需要再提及的基础就是，负数在内存中是以补码形式保存的。这道题也展现出了这种设计的优势-统一了正数负数的加减法(e.t. 0xffffffff(-1) - 1 = 0xfffffffe(-2))。

### 代码

``` java
public int hammingWeight(int n) {
    int count = 0;
    while(n != 0){
        count++;
        n = (n - 1) & n;
    }
    return count;
}
```

## Longest Substring Without Repeating Characters

### 问题描述

Given a string, find the length of the longest substring without repeating characters.

### 解决思路

用Map记录每个元素最后一次出现的位置(除这次)，用当前位置减去Map中的记录位置即可得到这一部分的无重复子串长度。

### 代码

``` java
public int lengthOfLongestSubstring(String s) {
    char[] input = s.toCharArray();
    int max = 0;
    int start = -1;
    Map<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < input.length; i++){
        if (map.containsKey(input[i]))
            start = start > map.get(input[i]) ? start : map.get(input[i]);
        map.put(input[i], i);
        max = Math.max(max, i - start);
    }
    return max;
}
```

## Increasing Triplet Subsequence

### 问题描述

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.

Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

### 解决思路

该题的重点在于仅判断存在与否而不关心具体位置。在下文给出的代码中，最终low所代表元素并非真正合适三元组的首位。然而这并不影响算法正确性，算法结束时mid不为Int最大值即说明存在一个合适元素满足其值小于mid。

### 代码

``` java
public boolean increasingTriplet(int[] nums) {
    int low = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
    for(int i = 0; i < nums.length; i++){
        if(nums[i] <= low)
            low = nums[i];
        else if(nums[i] <= mid)
            mid = nums[i];
        else
            return true;
    }
    return false;
}
```

## Find Peak Element

### 问题描述

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.


### 解决思路

这道题的O(logn)解法思路比较独特。保证logn的复杂度要求我们的搜索一定至少是二分这样的搜索范围指数型缩小的方法。

要理解下文中给出的解法，先要挖掘一下这道题的规律。在这道题中我们可以发现，若一个区间的两端均大于外侧，则区间内一定至少存在一个peak元素。

这样的话，只要保持上文中条件，二分缩小区间，当start与end相遇时，所得元素即为所求。

### 代码

``` java
public static int findPeakElement(int[] nums) {
    return findPeakElementPlusStep(nums, 0, nums.length - 1);
}

public static int findPeakElementPlusStep(int[] nums, int start , int end) {
    if(start == end)
        return start;
    int mid = (start + end) / 2;
    if(nums[mid] > nums[mid + 1])
        return findPeakElementPlusStep(nums, start, mid);
    else
        return findPeakElementPlusStep(nums, mid + 1, end);
}
```

## Search for a Range

### 问题描述

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

### 解决思路

显然这道题需要通过二分搜索来解，值得注意的是通过对循环条件的修改可以使二分搜索达到找到目标第一个位置或最后一个位置的效果，不过这种写法的边界控制比较费力。

### 代码

``` java
public int[] searchRange(int[] nums, int target) {
    int low = 0, mid = 0, high = nums.length - 1;
    int[] result = {-1, -1};
    while(low < high){
        mid = (low + high) / 2;
        if(nums[mid] >= target)
            high = mid;
        else
            low = mid + 1;
    }
    if(nums.length == 0 || nums[low] != target)
        return result;
    result[0] = low;
    high = nums.length - 1;
    while(low < high){
        mid = (low + high + 1) / 2;
        if(nums[mid] <= target)
            low = mid;
        else
            high = mid - 1;
    }
    result[1] = high;
    return result;
}
```

## Search a 2D Matrix II

### 问题描述

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

+ Integers in each row are sorted in ascending from left to right.
+ Integers in each column are sorted in ascending from top to bottom.

### 解决思路

一上来便有的常规思路就是从左上角开始两路递归，这种写法复杂度优于O(m * n)的写法但对一些测试用例依然效率不足

另一种巧妙的思路在于改变起始点的位置，若从右上开始递归过程则从两路探测变为较大向下较小向左，复杂度缩减为O(m + n)

### 代码

``` java
public static boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0)
        return false;
    if(matrix[0].length == 0)
        return false;
    return searchMatrixPlusStep(matrix, target, 0, matrix[0].length - 1);
}

public static boolean searchMatrixPlusStep(int[][] matrix, int target, int row, int col){
    if(row >= matrix.length || col < 0)
        return false;
    if(matrix[row][col] == target)
        return true;
    else if(matrix[row][col] < target)
        return searchMatrixPlusStep(matrix, target, row + 1, col);
    else
        return searchMatrixPlusStep(matrix, target, row, col - 1);
}
```

## Jump Game

### 问题描述

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

### 解决思路

作为动态规划分类下的问题，产生的第一个思路便是记录每个子问题的结果，在这道题中便是从倒数第二个位置开始判断这个位置能到达的位置中是否包含可到结尾的位置，若有则将该位置标记为可到达结尾的位置。

如果再深入思考一下这道题所给出的条件，这种解法还有优化的空间。若将求解思路变为若该位置可到达结尾，则该位置成为新的结尾，用于记录子问题结果的数组便可以去掉，再O(1)的空间复杂度下就可以解决这个问题。

### 代码

``` java
public boolean canJump(int[] nums) {
    int last = nums.length - 1;
    for(int i = nums.length - 2; i >= 0; i--){
        if(nums[i] >= last - i)
            last = last <= i? last : i;
    }
    if(last == 0)
        return true;
    return false;
}
```

## Coin Change

### 问题描述

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

### 解决思路

这道题也是背包问题的衍生题目之一，定义好子问题求解不难

写出这道题的主要原因还是又犯了老毛病，又又又又又又又把子问题重复求解了不知道多少遍

当然动态规划有时往往与直接递归求解思路相反，不熟练想不起来

不过既然使用了动态规划，就要好好的把公共子问题提出，不然效率天差地别

### 代码

``` java
public static int coinChange(int[] coins, int amount) {
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
```

## Longest Increasing Subsequence

### 问题描述

Given an unsorted array of integers, find the length of longest increasing subsequence.

### 解决思路

最直接的思路是将子问题定义为“求解头部到该位置的最长递增子序列长度”，这样可以得到O(n^2)时间复杂度的解法

另一种更巧妙的思路是将子问题定义为“求解头部到该位置各长度子序列最小末尾数组”，这种思路下的解法时间复杂度为O(nlogn)

末尾数组是一个很有意思的思路，事实上在每次解决一个新的子问题时，我们都不关心前一个子问题中的子序列具体样子。而这种解法提供我们解题所需要的局部信息的最小集：1.最长的链有多少个元素， 2.每种长度的链的最小末尾是多少

### 代码

``` java
public int lengthOfLIS(int[] nums) {
    if(nums.length == 0)
        return 0;
    int[] dp = new int[nums.length];
    int max = 0;
    for(int i = 0; i < nums.length; i++){
        for(int j = 0; j < i; j++) {
            if (nums[i] > nums[j])
                dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        max = Math.max(max, dp[i]);
    }
    return max + 1;
}
```

## Insert Delete GetRandom O(1)

### 问题描述

Design a data structure that supports all following operations in average O(1) time.

1. insert(val): Inserts an item val to the set if not already present.
2. remove(val): Removes an item val from the set if present.
3. getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

### 解决思路

因为插入和删除时要判断是否含有该元素且需要O(1)时间，故Hash不可避

难得的机会就简单研究了一下java自身HashMap的hash方法。其中比较重要的一点就是如何将32位大小的哈希值空间映射到容器大小。对于这个问题java给出的处理方法是与容器容量减一的值做二进制与
``` java
key & (length - 1)
```
与IP地址掩码的处理方式十分相近。需要注意的是，只有容器大小为2的整倍数时，才能比较好的利用这种方法

### 代码

``` java
class RandomizedSet {

    int capacity = 256;

    int size = 0;

    int[] weight = new int[256];

    ArrayList<Integer>[] nums = new ArrayList[256];

    /** Initialize your data structure here. */
    public RandomizedSet() {
        for(int i = 0; i < nums.length; i++)
            nums[i] = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int hashcode = Integer.hashCode(val) & (capacity - 1);
        if(nums[hashcode].contains(val))
            return false;
        nums[hashcode].add(val);
        weight[hashcode]++;
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int hashcode = Integer.hashCode(val) & (capacity - 1);
        if(!nums[hashcode].contains(val))
            return false;
        nums[hashcode].remove(nums[hashcode].indexOf(val));
        weight[hashcode]--;
        size--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int ran = Math.abs(random.nextInt() % size) + 1;
        int sum = 0, pos1 = -1, pos2 = 0;
        while(sum < ran){
            pos1++;
            sum += weight[pos1];
        }
        pos2 = ran - sum + weight[pos1] - 1;
        return nums[pos1].get(pos2);
    }
    
}
```

## 编程细节

1. 求中值时，a + (b - a) / 2的写法可以避免(a + b) / 2导致的溢出问题
2. 对于某些需要额外信息的情况，加减操作往往有奇效(e.t. 原地置换、[Min Stack](https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/562/discuss/49031/Share-my-Java-solution-with-ONLY-ONE-stack))
3. 判断n是a的整数次幂，只需要用该存储类型的最大a次幂除n取余即可(e.t. [Power of Three](https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/745/discuss/77856/1-line-java-solution-without-loop-recursion))
4. 素数是一种很骚的操作，特点在于任意一种素数组合都只有唯一一个合数与之对应(e.t. [Group Anagrams](https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/discuss/19183/Java-beat-100!!!-use-prime-number))
5. Java中，改变队列插入顺序当然可以用一个栈中转，然而也可以直接add(0, val)，毕竟大家都是LinkedList
6. 在图类问题中，记录已经经过的路径除了开辟一个boolean二维数组以外，还可以通过修改原图达成。另一方面，失败分支的标记路径撤销也值得注意。(e.t. [Word Search](https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/797/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.))
7. 对排列组合问题求解往往需要用double来存储过程解，一方面先乘后除很容易造成类型溢出，另一方面乘除结合过程解很难为整数。在乘除结束后可以使用Math.round()进行取整.(e.t. [Unique Paths](https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/808/discuss/22981/My-AC-solution-using-formula))
8. 对逻辑环的判定可以使用Floyd Cycle detection algorithm(e.t. [Linked List Cycle](https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/773/discuss/44489/O(1)-Space-Solution), [Happy Number](https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/815/discuss/56917/My-solution-in-C\(-O(1)-space-and-no-magic-math-property-involved-)))