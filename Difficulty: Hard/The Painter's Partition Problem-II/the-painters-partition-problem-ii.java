//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    boolean check(int[] arr, int k, int length){
        int sum = 0;
        k--;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > length){
                sum = arr[i];
                k--;
            }
        }
        return k >= 0;
    }
    public int minTime(int[] arr, int k) {
        int maxtime = 0;
        int mintime = arr[0];
        for(int i : arr){
            maxtime += i;
            if(mintime < i) mintime = i;
        }
        
        int last = maxtime;
        while(mintime <= maxtime){
            int mid = mintime + ((maxtime - mintime) >> 1);
            if(check(arr, k, mid)){
                last = mid;
                maxtime = mid - 1;
            }
            else{
                mintime = mid + 1;
            }
        }
        return last;
    }
}
