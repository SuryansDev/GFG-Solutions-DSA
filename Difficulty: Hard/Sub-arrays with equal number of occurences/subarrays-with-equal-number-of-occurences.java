//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends

class Solution {
    static int sameOccurrence(int arr[], int x, int y) {
        int ans =0;
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int ctX = 0, ctY = 0;
        for(int i : arr){
            if(i == x) ctX++;
            if(i == y) ctY++;
            mp.put(ctX-ctY, mp.getOrDefault((ctX - ctY), 0) + 1);
        }
        
        for(int i : mp.keySet()){
            int val = mp.get(i);
            ans += (val * (val - 1)) / 2;
        }
        return ans;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends