//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(HashSet<Character>[] adj, int[] visited, int node, StringBuilder ans){
        if(ans.toString().equals("0")) return;
        for(Character c : adj[node]){
            if(visited[c - 'a'] == 0){
                visited[node] = 1;
                dfs(adj, visited, c - 'a', ans);
            }
            else if(visited[c - 'a'] == 1){
                ans = new StringBuilder("0");
                return;
            }
        }
        visited[node] = 2;
        ans.append((char) ('a' + node));
    }
    public String findOrder(String[] dict, int n, int k) {
        HashSet<Integer> present = new HashSet<>();
        for(String s : dict){
            for(char c : s.toCharArray()){
                present.add(c - 'a');
            }
        }
        HashSet<Character>[] adj = new HashSet[26];
        for(int i = 0; i < 26; i++){
            adj[i] = new HashSet<>();
        }
        //insert connections
        for(int i = 0; i < n - 1; i++){
            //find first different
            for(int j = 0; j < dict[i].length(); j++){
                if(j >= dict[i+1].length()) return "";
                if(dict[i].charAt(j) != dict[i+1].charAt(j)){
                    adj[dict[i].charAt(j) - 'a'].add(dict[i + 1].charAt(j));
                    break;
                }
            }
        }
        //graph complete
        StringBuilder ans = new StringBuilder();
        int[] visited = new int[26];
        for(int i : present){
            if(visited[i] == 0){
                dfs(adj, visited, i, ans);
                if(ans.equals("0")) return "";
            }
        }
        return ans.reverse().toString();
    }
}