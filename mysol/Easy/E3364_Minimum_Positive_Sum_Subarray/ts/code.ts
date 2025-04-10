function minimumSumSubarray(nums: number[], l: number, r: number): number {
  const n = nums.length;
  const prefix: number[] = new Array(n + 1).fill(0);

  // Build prefix sum array
  for (let i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
  }

  let minPositiveSum = Infinity;

  // Try all subarray lengths from l to r
  for (let len = l; len <= r; len++) {
      for (let i = 0; i + len <= n; i++) {
          const sum = prefix[i + len] - prefix[i];
          if (sum > 0) {
              minPositiveSum = Math.min(minPositiveSum, sum);
          }
      }
  }

  return minPositiveSum === Infinity ? -1 : minPositiveSum;
};

const input: number[] = [3, -2, 1, 4];
const l: number = 2, r: number = 3;
const results = minimumSumSubarray(input, l, r);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

