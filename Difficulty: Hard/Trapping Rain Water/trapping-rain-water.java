//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        int[] pref = new int[arr.length];   
        int[] suff = new int[arr.length];
        int high = 0;
        for(int i = 0; i < arr.length; i++){
            pref[i] = high;
            if(high < arr[i]) high = arr[i];
        }
        high = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            suff[i] = high;
            if(high < arr[i]) high = arr[i];
        }
        
        int water = 0;
        for(int i = 0; i < arr.length; i++){
            water += Math.max(0, Math.min(pref[i], suff[i]) - arr[i]);
        }
        return water;
    }
}
