function longestSubarray(nums: number[]): number {
  let left = 0, right = 0;
  let zeroCount = 0;
  let maxLength = 0;

  while (right < nums.length) {
      // If the current element is 0, increment the zero count
      if (nums[right] === 0) {
          zeroCount++;
      }

      // If zero count exceeds 1, shrink the window from the left
      while (zeroCount > 1) {
          if (nums[left] === 0) {
              zeroCount--;
          }
          left++;
      }

      // Update the maximum length of the window, minus 1 if we include a zero
      maxLength = Math.max(maxLength, right - left);

      right++;
  }

  // Return the maximum length found, minus 1 for the removed element
  return maxLength === 0 ? 0 : maxLength;
};

let input1 = [0,1,1,1,0,1,1,0,1];
let output1 = longestSubarray(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

