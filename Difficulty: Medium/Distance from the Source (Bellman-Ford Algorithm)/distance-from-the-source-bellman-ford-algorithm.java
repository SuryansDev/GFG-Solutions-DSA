//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellmanFord(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*   Function to implement Bellman Ford
 *   edges: vector of vectors which represents the graph
 *   S: source vertex to start traversing graph with
 *   V: number of vertices
 */
 //can't i just do simple dijkstra and then check one more time
class Solution {
    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        
        //algo
        //relax v-1 times
        dist[src] = 0;
        for(int j = 0; j< V - 1; j++){
            for(ArrayList<Integer> i : edges){
                if(dist[i.get(0)] == 100000000) continue;
                if(dist[i.get(1)] > dist[i.get(0)] + i.get(2)){
                    dist[i.get(1)] = dist[i.get(0)] + i.get(2);
                }
            }
        }
        //negative weight cycle detection
        for(ArrayList<Integer> i : edges){
            if(dist[i.get(0)] == 100000000) continue;
            if(dist[i.get(1)] > dist[i.get(0)] + i.get(2)){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
