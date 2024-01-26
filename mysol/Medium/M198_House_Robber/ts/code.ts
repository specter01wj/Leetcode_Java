function rob(nums: number[]): number {
  if (nums.length === 0) return 0;
  if (nums.length === 1) return nums[0];

  let dp: number[] = [nums[0], Math.max(nums[0], nums[1])];

  for (let i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
  }

  return dp[nums.length - 1];
};

let input1 = [2,7,9,3,1];
let output1 = rob(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

