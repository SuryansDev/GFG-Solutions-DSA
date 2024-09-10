//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static int evenlyDivides(int N){
        int[] digits = new int[10];
        int ans = 0,temp = N;
        while(temp>0){
            digits[temp%10]++;
            temp /= 10;
        }
        for(int i = 1; i <10;i++){
            if(N%i == 0) ans += digits[i];
        }
        return ans;
    }
}