//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < mat.length; i++) stack.push(i);
        
        while(stack.size() > 1){
            int p1 = stack.pop();
            int p2 = stack.pop();
            
            if(mat[p1][p2] == 0){
                if(mat[p2][p1] == 1){
                    stack.push(p1);
                }
            }
            else{
                if(mat[p2][p1] == 0){
                    stack.push(p2);
                }
            }
        }
        if(stack.isEmpty()) return -1;
        int potentialCeleb = stack.pop();
        for(int i = 0; i < mat.length; i++)
            if(mat[potentialCeleb][i] == 1 || (i != potentialCeleb && mat[i][potentialCeleb] == 0))
                return -1;
        
        return potentialCeleb;
    }
}