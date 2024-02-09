class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 1 4 8 5 16 9
        int n=nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int lastIdx = -1;

        // base case
        for(int i=0; i<n; i++){
            dp[i]=1;
        }

        Arrays.sort(nums);
        //main cases
        int maxLen = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            hash[i] = i;
            for(int j=0; j<i; j++){
                if((nums[i] % nums[j]==0) && 1+dp[j] > dp[i]){
                    dp[i] = 1+dp[j];
                    hash[i] = j; //prev
                }
            }
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        ans.add(nums[lastIdx]);
        while(hash[lastIdx] != lastIdx){
            lastIdx = hash[lastIdx];
            ans.add(nums[lastIdx]);
        }
        return ans;

    }
}
