function longestCommonSubsequence(text1: string, text2: string): number {
  const m: number = text1.length;
  const n: number = text2.length;

  // Initialize a 2D array with zeros
  let dp: number[][] = Array.from({ length: m + 1 }, () => Array(n + 1).fill(0));

  // Fill the dp table
  for (let i = 1; i <= m; i++) {
      for (let j = 1; j <= n; j++) {
          if (text1.charAt(i - 1) === text2.charAt(j - 1)) {
              // If characters match, add 1 to the diagonal value
              dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
              // Otherwise, take the maximum of the left and top values
              dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
      }
  }

  // The bottom-right cell contains the length of the longest common subsequence
  return dp[m][n];
};

let text1 = "abcde", text2 = "ace";
let output1 = longestCommonSubsequence(text1, text2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

