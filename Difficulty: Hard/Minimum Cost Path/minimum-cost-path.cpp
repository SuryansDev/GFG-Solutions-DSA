//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


#include <vector>
#include <queue>
#include <functional>

using namespace std;

class Solution {
public:
    // Comparator for min-heap (priority queue).
    static bool cmp(const pair<int, pair<int, int>>& p1, const pair<int, pair<int, int>>& p2) {
        return p1.first > p2.first; // Min-heap based on the cost
    }

    int minimumCostPath(vector<vector<int>>& grid) {
        int n = grid.size();
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, decltype(&cmp)> toVisit(&cmp);
        
        toVisit.push({grid[0][0], {0, 0}});
        
        pair<int, int> ans = {n - 1, n - 1};

        while (!toVisit.empty()) {
            int val = toVisit.top().first;
            int row = toVisit.top().second.first;
            int col = toVisit.top().second.second;
            toVisit.pop();
            
            // If we've reached the bottom-right corner, return the cost.
            if (row == ans.first && col == ans.second) {
                return val;
            }
            
            // Skip processing if this cell has already been visited.
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            
            // Explore all possible directions.
            if (row + 1 < n && !visited[row + 1][col]) {
                toVisit.push({val + grid[row + 1][col], {row + 1, col}});
            }
            if (col + 1 < n && !visited[row][col + 1]) {
                toVisit.push({val + grid[row][col + 1], {row, col + 1}});
            }
            if (row - 1 >= 0 && !visited[row - 1][col]) {
                toVisit.push({val + grid[row - 1][col], {row - 1, col}});
            }
            if (col - 1 >= 0 && !visited[row][col - 1]) {
                toVisit.push({val + grid[row][col - 1], {row, col - 1}});
            }
        }
        
        // Return -1 if no path found, though the problem guarantees a path.
        return -1;
    }
};


//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>grid(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> grid[i][j];
			}
		}
		Solution obj;
		int ans = obj.minimumCostPath(grid);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends