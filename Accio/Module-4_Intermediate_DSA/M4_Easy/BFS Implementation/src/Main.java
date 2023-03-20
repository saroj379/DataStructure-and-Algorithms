import java.util.*;
import java.io.*;

class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;

    Graph(int v) {
        this.vertices = v+1;
        adjList = new ArrayList[v+1];

        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);

    }

    void BFS(int x) {
        // Creating a queue and add the 1st vertices
        Queue<Integer> qu = new LinkedList<>();
        qu.add(x);

        // Created a boolean to moniter that i am reaching the vertex already or not
        boolean[] visited = new boolean[vertices];

        while(qu.size() > 0){
            int currVertx = qu.remove();

            // if already visited then simply continue
            if(visited[currVertx]) continue;
            // making the true coz i visited
            visited[currVertx] = true;

            // printing the visited vertex
            System.out.print(currVertx+" ");

            // iterate over the items of arr -> ArrayList
            for(int nbr : adjList[currVertx]){
                // if not visited then add to the qu as arr idx
                if(!visited[nbr]) qu.add(nbr);
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
