class Solution {
    public long largestPerimeter(int[] nums) {
        //base case
        int n=nums.length;
        if(n<3) return -1;
        
        Arrays.sort(nums);
        
        long[] psum = new long[n];
        psum[0] = nums[0];
        for(int i=1; i<n; i++) psum[i] = psum[i-1]+nums[i];
        for(int i=n-2; i>=1; i--){
            if(psum[i] > nums[i+1])
                return psum[i+1];
        }
        return -1;
        
    }
}
