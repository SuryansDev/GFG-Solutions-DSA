//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // your code here
        int ans = 0;
        int index = 0;
        while(index < arr.length - 1 && arr[index] != 0){
            int nextIndex = index + arr[index];
            if(nextIndex >= arr.length - 1){
                index = nextIndex;
                ans++;
                break;
            }
            for(int i = 1; i <= arr[index] && index + i < arr.length; i++){
                if(index + i + arr[index + i] > nextIndex + arr[nextIndex]) nextIndex = index + i;
            }
            index = nextIndex;
            ans++;
        }
        if (index >= arr.length - 1) return ans;
        else return -1;
    }
}