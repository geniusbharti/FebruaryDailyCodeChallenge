class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        //Optimal
    int cnt = 0;
    int ele = 0;

    for(int i=0; i<n; i++){
        if(cnt == 0){
            cnt = 1;
            ele = nums[i];
        }else if(ele == nums[i]){
            cnt++;
        }else{
            cnt--;
        }
    }

    return ele;
}}
