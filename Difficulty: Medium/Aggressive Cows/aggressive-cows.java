//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean check(int[] stalls, int dist, int cows){
        int last = -dist - 1;
        for(int i = 0; i < stalls.length && cows > 0; i++){
            if(stalls[i] - last >= dist){
                last = stalls[i];
                cows--;
            }
        }
        return cows == 0;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int last = 1;
        int maxDist = stalls[n - 1] - stalls[0];
        int minDist = 0;
        while(minDist <= maxDist){
            int mid = (minDist + maxDist) >> 1;
            if(check(stalls, mid, k)){
                last = mid;
                minDist = mid + 1;
            }
            else{
                maxDist = mid - 1;
            }
        }
        return last;
    }
}