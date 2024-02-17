class Solution {
    // TC: O(NlogK) SC: O(K)
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //I will use bricks for smaller differences assuming I have limited bricks ; 
        // so that I can keep ladders for larger differences

        //to maintain min diff at top I use min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //compare each adj. height 
        for(int i=1; i<heights.length; i++){
            int diff = heights[i] - heights[i-1];

            //put only positive 
            if(diff > 0){
                minHeap.offer(diff);
            }

            //cover larger diff. with ladders; but when out of ladders use bricks
            if(minHeap.size() > ladders){
                int minDiff = minHeap.poll();
                //use brick for this diff
                bricks -= minDiff;
            }

            //if we need more bricks than left to reach ith building -> not possible to reach
            if(bricks < 0){
                return i-1;
            }

        }

        // reached last building; never run out of bricks/ladders
        return heights.length - 1;
    }
}
