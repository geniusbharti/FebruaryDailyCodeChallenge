class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return new int[0][0];
        if(n%3 != 0) return new int[0][0];
        Arrays.sort(nums);
        // int[] vis = new int[n];
        
        List<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(al.size() >= 3){
                ans.add(al);
                al = new ArrayList<Integer>();
            }
            // if(vis[i] == 0){
                int val =  0;
                if(!al.isEmpty()) val = nums[i] - al.get(0);
                if(al.isEmpty() || (val)<= k){
                    al.add(nums[i]);
                    // vis[i] = 1;
                }else{
                    return new int[0][0];
                }
            // }
        }
        
        // Check if the last array needs to be added
        if (!al.isEmpty()) {
            ans.add(al);
        }

        // Check if the number of arrays is correct
        if (ans.size() != n / 3) {
            return new int[0][0];
        }
        
        int[][] ansf = new int[ans.size()][3];
        for(int i = 0; i<ans.size(); i++){
            for(int j=0; j<3; j++){
                ansf[i][j] = ans.get(i).get(j);
            }
        }
        
        return ansf;
        
    }
}
