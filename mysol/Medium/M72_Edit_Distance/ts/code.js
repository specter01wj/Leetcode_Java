function minDistance(word1, word2) {
    var m = word1.length;
    var n = word2.length;
    var dp = Array.from({ length: m + 1 }, function () { return Array(n + 1).fill(0); });
    // Initialize the first row and column
    for (var i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (var j = 0; j <= n; j++) {
        dp[0][j] = j;
    }
    // Compute the distances
    for (var i = 1; i <= m; i++) {
        for (var j = 1; j <= n; j++) {
            if (word1.charAt(i - 1) === word2.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1]; // No operation needed
            }
            else {
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                dp[i - 1][j], // Delete
                dp[i][j - 1] // Insert
                );
            }
        }
    }
    return dp[m][n];
}
;
var word1 = "horse", word2 = "ros";
var output1 = minDistance(word1, word2);
var webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);
