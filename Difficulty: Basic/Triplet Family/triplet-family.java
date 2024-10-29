//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {
    boolean binSearch(int[] arr, int start, int end, int key){
        int mid = (start + end) / 2;
        while(start <= end){
            if(arr[mid] > key) end = mid - 1;
            else if (arr[mid] < key) start = mid + 1;
            else return true;
            mid = (start + end) / 2;
        }
        return false;
    }
    public boolean findTriplet(int[] arr) {
        //for iterate from i = 0 to n - 2
        //for each j from i + 1 to n - 1 
        //perform binary search for arr[i] + arr[j] from j+1 to end
        //if found return true else continue
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i ++){
            for(int j = i + 1; j < arr.length - 1; j++){
                if(binSearch(arr, j + 1, arr.length - 1, arr[i] + arr[j])) return true;
            }
        }
        return false;
        
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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
            Solution obj = new Solution();
            boolean res = obj.findTriplet(arr);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends