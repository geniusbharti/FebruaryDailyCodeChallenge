class Solution {
    class Pair{
        int val;
        int fq;
        Pair(int val, int fq){
            this.val = val;
            this.fq=fq;
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        //1-2, 3-3, 4-1, 2-1
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.fq-b.fq);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        while(k > 0){
            Pair p = pq.peek();
            k = k - p.fq;
            pq.poll();
        }
        
        return k < 0 ? pq.size()+1 : pq.size();
    }
}
