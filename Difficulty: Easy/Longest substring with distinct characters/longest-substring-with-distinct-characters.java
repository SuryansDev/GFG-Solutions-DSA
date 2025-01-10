//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        boolean[] found = new boolean[26];
        int j = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            while(found[s.charAt(i) - 'a'])
                found[s.charAt(j++) - 'a'] = false;
            found[s.charAt(i) - 'a'] = true;
            if(max < i - j + 1) max = i - j + 1;
        }
        return max;
    }
}