import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static class Helper{
        int node, wsf;
        String psf;

        Helper(int node, int wsf, String psf){
            this.node = node;
            this.wsf = wsf;
            this.psf = psf;
        }
    }
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int cost[] = new int[V];
        Arrays.fill(cost, -1);

        boolean[] vis = new boolean[V];

        PriorityQueue<Helper> pq = new PriorityQueue<>((a, b) -> {
            return a.wsf - b.wsf;
        });
        pq.add(new Helper(S, 0, S+""));

        while(pq.size() > 0){
            Helper pair = pq.remove();
            // if already visited
            if(vis[pair.node]) continue;
            vis[pair.node] = true;
            cost[pair.node] = pair.wsf;

            // to check the path and weight
            // System.out.println(pair.psf+"@"+pair.wsf);

            for(ArrayList<Integer> e : adj.get(pair.node)){
                int nbr = e.get(0);
                int wt = e.get(1);

                if(!vis[nbr]) pq.add(new Helper(nbr, pair.wsf+wt, pair.psf+nbr));
            }
        }
        return cost;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        String str[] = read.readLine().trim().split(" ");
        int V = Integer.parseInt(str[0]);
        int E = Integer.parseInt(str[1]);

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        int i=0;
        while (i++<E) {
            String S[] = read.readLine().trim().split(" ");
            int u = Integer.parseInt(S[0]);
            int v = Integer.parseInt(S[1]);
            int w = Integer.parseInt(S[2]);
            ArrayList<Integer> t1 = new ArrayList<Integer>();
            ArrayList<Integer> t2 = new ArrayList<Integer>();
            t1.add(v);
            t1.add(w);
            t2.add(u);
            t2.add(w);
            adj.get(u).add(t1);
            adj.get(v).add(t2);
        }

        int S = Integer.parseInt(read.readLine());

        int[] ptr = dijkstra(V, adj, S);

        for(i=0; i<V; i++)
            System.out.print(ptr[i] + " ");
        System.out.println();
    }


}
