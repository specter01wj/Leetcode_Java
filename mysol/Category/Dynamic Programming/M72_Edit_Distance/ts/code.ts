function minDistance(word1: string, word2: string): number {
  let m: number = word1.length;
  let n: number = word2.length;
  let dp: number[][] = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

  // Initialize the first row and column
  for (let i = 0; i <= m; i++) {
      dp[i][0] = i;
  }
  for (let j = 0; j <= n; j++) {
      dp[0][j] = j;
  }

  // Compute the distances
  for (let i = 1; i <= m; i++) {
      for (let j = 1; j <= n; j++) {
          if (word1.charAt(i - 1) === word2.charAt(j - 1)) {
              dp[i][j] = dp[i - 1][j - 1]; // No operation needed
          } else {
              dp[i][j] = 1 + Math.min(
                  dp[i - 1][j - 1], // Replace
                  dp[i - 1][j],     // Delete
                  dp[i][j - 1]      // Insert
              );
          }
      }
  }

  return dp[m][n];
};

let word1 = "horse", word2 = "ros";
let output1 = minDistance(word1, word2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

