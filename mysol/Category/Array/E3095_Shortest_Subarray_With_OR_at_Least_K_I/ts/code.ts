function minimumSubarrayLength(nums: number[], k: number): number {
  const n = nums.length;
  let minLength = Infinity;

  for (let i = 0; i < n; i++) {
      let orValue = 0;
      for (let j = i; j < n; j++) {
          orValue |= nums[j];
          if (orValue >= k) {
              minLength = Math.min(minLength, j - i + 1);
              break; // No need to continue since we found a valid subarray
          }
      }
  }

  return minLength === Infinity ? -1 : minLength;
};

const input: number[] = [2,1,8];
const k: number = 10;
const results = minimumSubarrayLength(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

