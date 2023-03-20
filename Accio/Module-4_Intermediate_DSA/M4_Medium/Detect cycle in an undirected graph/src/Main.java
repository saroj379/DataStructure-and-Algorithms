import java.io.*;
import java.util.*;

class Solution {

    static boolean bfs(ArrayList<ArrayList<Integer>> graph, int s, boolean[] vis){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(s);

        int n = graph.size();

        while(qu.size() > 0){
            int curr = qu.remove();
            // if already visited return true
            if(vis[curr]) return true;
            vis[curr] = true;

            // add the vertecies if not visited yet
            for(int nbr : graph.get(curr)){
                if(!vis[nbr]) qu.add(nbr);
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i=0; i < V; i++){
            if(vis[i]) continue;
            boolean isPresent = bfs(adj, i, vis);
            // is cycle is there then return true directly from here
            if(isPresent) return true;
        }

        return false;
    }

}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}