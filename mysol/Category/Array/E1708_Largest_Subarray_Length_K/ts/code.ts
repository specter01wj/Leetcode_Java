
function largestSubarray(nums: number[], k: number): number[] {
  const n = nums.length;
  let startIndex = 0;

  // Iterate to find the subarray that starts at the largest value
  for (let i = 1; i <= n - k; i++) {
      for (let j = 0; j < k; j++) {
          if (nums[startIndex + j] < nums[i + j]) {
              startIndex = i;
              break;
          } else if (nums[startIndex + j] > nums[i + j]) {
              break;
          }
      }
  }

  // Return the subarray of length k starting from startIndex
  return nums.slice(startIndex, startIndex + k);
};

const input: number[] = [1,4,5,2,3];
const k: number = 3;
const results = largestSubarray(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

