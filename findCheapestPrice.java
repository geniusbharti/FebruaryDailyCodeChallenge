class Solution {
    public class Pair{
        // int from;
        int to;
        int cost;

        Pair(int to, int cost){
            // this.from = from;
            this.to = to;
            this.cost=cost;
        }
    }

    class Stop{
        int stop;
        int node;
        int dist;

        Stop(int stop, int node, int dist){
            this.stop  = stop;
            this.node = node;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;

        Queue<Stop> q = new ArrayDeque<>();
        q.add(new Stop(0, src, 0));

        while(!q.isEmpty()){
            Stop s = q.poll();

            int stp = s.stop;
            int nde = s.node;
            int dis = s.dist;

            if(stp > k) continue;

            for(Pair p : adj.get(nde)){
                int adjNde = p.to;
                int Wt = p.cost;

                if((dis + Wt) < dist[adjNde] && stp <= k){
                    dist[adjNde] = dis + Wt;
                    q.add(new Stop(stp + 1, adjNde, dis + Wt));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        else return dist[dst];

    }
}
