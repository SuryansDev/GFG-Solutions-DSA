//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] v, int node, boolean[] ans){
        if(ans[0] == true) return;
        v[node] = 1;
        for(int i : adj.get(node)){
            if(v[i] == 0) dfs(adj, v, i, ans);
            else if(i == node || v[i] == 1){
                ans[0] = true;
                return;
            }
        }
        v[node] = 2;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] v = new int[V];
        boolean[] ans = new boolean[]{false};
        for(int i = 0; i < V; i++){
            if(v[i] == 0) dfs(adj, v, i, ans);
            
        }
        return ans[0];
    }
}