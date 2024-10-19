//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // int x = Integer.parseInt(str);
        // if(x % 10 <= 5) return Integer.toString(x - (x%10));
        // else return Integer.toString(x - (x%10) + 10);
        //will need to add using strings
        StringBuilder s = new StringBuilder(str);
        int n = s.length() - 1;
        if(s.charAt(n)  <= '5') s.setCharAt(n, '0');
        else{
            s.setCharAt(n--, '0');
            while(n >= 0 && s.charAt(n) == '9'){
                s.setCharAt(n--, '0');
            }
            if(n < 0) s.insert(0, "1");
            else s.setCharAt(n, (char)(s.charAt(n) + 1));
        }
        return s.toString();
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends