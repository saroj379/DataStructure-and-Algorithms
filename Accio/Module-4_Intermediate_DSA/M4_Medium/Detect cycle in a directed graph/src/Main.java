import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    boolean bfs(ArrayList<Integer>[] graph, boolean[] vis, boolean[]path, int curr){
        vis[curr] = true;
        path[curr] = true;

        // for neighbour vertex
        for(int nbr : graph[curr]){
            if(!vis[nbr]){
                boolean cycleFound = bfs(graph, vis, path, nbr);
                if(cycleFound) return true;
            }
            // if both has not visited the check for next iteration
            else if(vis[nbr] && !path[nbr]) continue;
                // if both have return true
            else if(vis[nbr] && path[nbr]) return true;
        }
        // if not found then make it false abe follow-back
        path[curr] = false;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];

        for(int i =0; i < V; i++){
            if(vis[i])continue;
            boolean isPresent = bfs(adj, vis, path, i);
            if(isPresent) return true;
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}