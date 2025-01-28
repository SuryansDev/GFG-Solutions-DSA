//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    HashSet<String> ans;
    public void dfs(int[] freq, StringBuilder s, int charLeft){
        if(charLeft == 0) ans.add(s.toString());
        else{
            for(int i = 0; i < 26; i++){
                if(freq[i] > 0){
                    s.append((char)('A' + i));
                    freq[i]--;
                    dfs(freq, s, charLeft - 1);
                    s.setLength(s.length() - 1);
                    freq[i]++;
                }
            }
        }
    }
    public ArrayList<String> findPermutation(String s) {
        ans = new HashSet<>();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'A']++;
        }
        dfs(freq, new StringBuilder(), s.length());
        return new ArrayList<>(ans);
    }
}