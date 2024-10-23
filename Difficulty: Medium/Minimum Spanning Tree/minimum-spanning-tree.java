//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends



class Sets{
    int[][] sets;
    Sets(int n){
        sets = new int[n][2];
        for(int i = 0; i < n; i++){
            sets[i][0] = i;
            sets[i][1] = 1; 
        }//first part contains parent second contains rank
    }

    int findParent(int i){
        if(sets[i][0] != i) sets[i][0] = findParent(sets[i][0]);
        return sets[i][0];
    }
    
    void union(int i , int j){
        i = findParent(i);
        j = findParent(j);
        if(sets[i][1] >= sets[j][1]){
            sets[i][1] += sets[j][1];
            sets[j][0] = i;
        }else{
            sets[j][1] += sets[i][1];
            sets[i][0] = j;
        }
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int length = 0;
        Sets st = new Sets(V);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int k = 0; k < V; k++){
            List<int[]> i = adj.get(k);
            for(int[] j : i){
                pq.add(new int[]{k, j[0], j[1]});
            }
        }
        while(!pq.isEmpty()){
            int[] i = pq.poll();
            if(st.findParent(i[0]) != st.findParent(i[1])){
                length += i[2];
                st.union(i[0], i[1]);
            }
        }
        return length;
        
    }
}
// class Solution {
//     static int spanningTree(int V, int E, List<List<int[]>> adj) {
//         int dist = 0;
//         HashSet<Integer> connected = new HashSet<>();
//         //min heap
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]  - b[1]);
//         int count = 0;
//         //add min edge from first vertex
//         for(int[] edge : adj.get(0)) pq.add(edge);
//         connected.add(0);
//         while(count < V - 1){
//             int[] i = pq.poll();
//             if(!connected.contains(i[0])){
//                 connected.add(i[0]);
//                 dist += i[1];
//                 for(int[] j : adj.get(i[0])){
//                     pq.add(j);
//                 }
//                 count++;
//             }
            
//         }
//         return dist;
//     }
// }