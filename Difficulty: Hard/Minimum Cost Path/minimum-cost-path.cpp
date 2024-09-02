//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution {
public:
    // Function to return the minimum cost to reach the bottom-right cell from the top-left cell.
    int minimumCostPath(vector<vector<int>>& grid) {
        int n = grid.size();
        
        // Priority queue for Dijkstra’s algorithm (min-heap).
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> toVisit;
        
        // 2D vector to store the minimum cost to reach each cell.
        vector<vector<int>> minCost(n, vector<int>(n, INT_MAX));
        
        // Starting from the top-left corner.
        toVisit.push({grid[0][0], {0, 0}});
        minCost[0][0] = grid[0][0];
        
        // Directions for movement: right, down, left, up.
        vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!toVisit.empty()) {
            int cost = toVisit.top().first;
            int row = toVisit.top().second.first;
            int col = toVisit.top().second.second;
            toVisit.pop();
            
            // If we've reached the bottom-right corner, return the cost.
            if (row == n - 1 && col == n - 1) {
                return cost;
            }
            
            // Skip processing if this cell has already been visited with a lower cost.
            if (cost > minCost[row][col]) {
                continue;
            }
            
            // Explore all possible directions.
            for (auto dir : directions) {
                int newRow = row + dir.first;
                int newCol = col + dir.second;
                
                // Check if the new position is within bounds.
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    int newCost = cost + grid[newRow][newCol];
                    
                    // If a cheaper path is found to the new cell, update and push it into the queue.
                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        toVisit.push({newCost, {newRow, newCol}});
                    }
                }
            }
        }
        
        // Return the cost to reach the bottom-right corner.
        return minCost[n - 1][n - 1];
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