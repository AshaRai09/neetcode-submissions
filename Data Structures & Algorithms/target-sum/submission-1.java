class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      
        int total = 0;

        for (int num : nums) {
            total += num;
        }
        if (Math.abs(target) > total) {
            return 0;
        }

        if ((target + total) % 2 != 0) {
            return 0;
        }

        int requiredSum = (target + total) / 2;

        int[] dp = new int[requiredSum + 1];

        dp[0] = 1;

        for (int num : nums) {
            for (int sum = requiredSum; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[requiredSum];  
    }
}
