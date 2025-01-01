//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    int[] getCharFreq(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c - 'a']++;
        return freq;
    }
    boolean compareFreq(int[] freq1, int[] freq2){
        for(int i = 0; i < freq1.length; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        int[][] frequencies = new int[arr.length][26];
        for(int i = 0; i < arr.length; i++) frequencies[i] = getCharFreq(arr[i]);
        
        boolean[] taken = new boolean[arr.length];
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i = 0; i < frequencies.length; i++){
            if(taken[i]) continue;
            
            ArrayList<String> group = new ArrayList<>();
            group.add(arr[i]);
            taken[i] = true;
            
            for(int j = 0; j < arr.length; j++){
                if(taken[j]) continue;
                
                if(compareFreq(frequencies[i], frequencies[j])){
                    taken[j] = true;
                    group.add(arr[j]);
                }
            }
            
            ans.add(group);
        }
        
        return ans;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends