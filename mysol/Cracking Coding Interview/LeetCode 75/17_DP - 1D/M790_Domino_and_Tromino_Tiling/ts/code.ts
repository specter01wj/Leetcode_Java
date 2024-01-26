function numTilings(n: number): number {
  const MOD: number = 1000000007;
  if (n <= 2) return n;

  let dp: number[] = new Array(n + 1).fill(0);
  dp[0] = 1; // base case for an empty board
  dp[1] = 1; // only one way to tile a 2x1 board
  dp[2] = 2; // two ways to tile a 2x2 board

  for (let i = 3; i <= n; i++) {
      dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
  }

  return dp[n];
};

let input1 = 3;









let output1 = numTilings(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

