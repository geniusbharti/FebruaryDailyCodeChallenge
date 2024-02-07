class Solution {
    class Pair{
        char ch;
        int frq;
        
        Pair(char ch, int frq){
            this.ch = ch;
            this.frq = frq;
        }
    } 

    public String frequencySort(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();

        for(char c: s.toCharArray())  mpp.put(c, mpp.getOrDefault(c,0) + 1);
        

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.frq,a.frq));
        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size()>0){
            Pair p = pq.remove();
            for(int i=0; i<p.frq; i++){
                // String str = ""+ p.ch;
                // sb.append(str);
                sb.append(p.ch);
            }
        }

        return sb.toString();

    }
}
