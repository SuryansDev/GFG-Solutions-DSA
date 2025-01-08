//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int binSearch(int[] arr, int target, int low){
        int high = arr.length - 1;
        int lastLow = low - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target){
                lastLow = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
                
            }
        }
        
        return lastLow;
    }
    
    static int countTriangles(int arr[]) {
        Arrays.sort(arr);
        int triangles = 0;
        for(int i = 0; i < arr.length - 2; i++){
            for(int j = i + 1;  j < arr.length - 1; j++){
                // System.out.println(binSearch(arr, arr[i] + arr[j] + 1, j + 1));
                triangles += binSearch(arr, arr[i] + arr[j] - 1, j + 1) - j;
            }
        }
        return triangles;
    }
}