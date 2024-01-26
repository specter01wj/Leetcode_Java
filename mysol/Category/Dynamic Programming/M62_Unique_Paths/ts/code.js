function uniquePaths(m, n) {
    // Create a 2D array with all elements initialized to 1
    var dp = new Array(m).fill(null).map(function () { return new Array(n).fill(1); });
    // Compute the number of paths for each cell in the grid
    for (var i = 1; i < m; i++) {
        for (var j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    // The bottom-right cell contains the total number of unique paths
    return dp[m - 1][n - 1];
}
;
var m = 3, n = 7;
var output1 = uniquePaths(m, n);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
