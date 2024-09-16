//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        int open = 0, close = 0;
        int ans = 0;
        //left ot right
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '(') open++;
            else {
                close ++;
                if(close > open){ 
                    open = 0;
                    close = 0;
                }
                else if(close == open && ans < 2 * close) ans = 2 * close;
            }
        }
        //right to left
        open = close = 0;
        for(int i = S.length() - 1; i >= 0; i--){
            if(S.charAt(i) == ')') open++;
            else {
                close ++;
                if(close > open){ 
                    open = 0;
                    close = 0;
                }
                else if(close == open && ans < 2 * close) ans = 2 * close;
            }
        }
        
        return ans;
    }
}