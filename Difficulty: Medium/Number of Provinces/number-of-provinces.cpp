//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int numProvinces(vector<vector<int>> adj, int V) {
        // code here
        vector<bool> visited(adj.size());
        int province = 0, next = 0;
        queue<int> q;
        while(next != -1){
            province++;
            q.push(next);
            visited[next] = true;
            while(!q.empty()){
                int temp = q.front();
                q.pop();
                for(int i = 0; i < adj.size(); i++){
                    if(adj[temp][i] && i !=next && !visited[i]){
                        visited[i] = true;
                        q.push(i);
                    }
                }
            }

            next = -1;
            for(int i = 0; i < visited.size(); i++){
                if(visited[i] == false){
                    next = i;
                    break;
                }
            }
        }
        return province;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int V,x;
        cin>>V;
        
        vector<vector<int>> adj;
        
        for(int i=0; i<V; i++)
        {
            vector<int> temp;
            for(int j=0; j<V; j++)
            {
                cin>>x;
                temp.push_back(x);
            }
            adj.push_back(temp);
        }
        

        Solution ob;
        cout << ob.numProvinces(adj,V) << endl;
    }
    return 0;
}
// } Driver Code Ends