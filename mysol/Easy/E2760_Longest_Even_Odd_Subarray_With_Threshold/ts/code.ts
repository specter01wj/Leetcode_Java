function longestAlternatingSubarray(nums: number[], threshold: number): number {
  let maxLength = 0;
  let i = 0;

  while (i < nums.length) {
      // Start counting only if nums[i] is even and within the threshold
      if (nums[i] % 2 === 0 && nums[i] <= threshold) {
          let currentLength = 1;
          let expectOdd = true;

          // Expand the subarray by checking alternating parity and threshold condition
          for (let j = i + 1; j < nums.length && nums[j] <= threshold; j++) {
              if ((nums[j] % 2 === 0) === expectOdd) {
                  break;
              }
              currentLength++;
              expectOdd = !expectOdd;  // Alternate between expecting even and odd
          }

          maxLength = Math.max(maxLength, currentLength);
      }
      i++;
  }

  return maxLength;
};

const input: number[] = [3,2,5,4];
const threshold: number = 5;
const results = longestAlternatingSubarray(input, threshold);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

