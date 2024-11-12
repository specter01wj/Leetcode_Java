function alternatingSubarray(nums: number[]): number {
  let maxLength = -1;
  let currentLength = 1;

  for (let i = 1; i < nums.length; i++) {
      // Check if the current pair alternates according to the condition
      if (nums[i] - nums[i - 1] === (currentLength % 2 === 1 ? 1 : -1)) {
          currentLength++;
      } else {
          // Reset currentLength to 2 if we find a new starting pair that alternates
          if (nums[i] - nums[i - 1] === 1) {
              currentLength = 2;
          } else {
              currentLength = 1;
          }
      }

      // Update maxLength if we found a longer alternating subarray
      if (currentLength > 1) {
          maxLength = Math.max(maxLength, currentLength);
      }
  }

  return maxLength;
};

const input: number[] = [2,3,4,3,4];
const results = alternatingSubarray(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

