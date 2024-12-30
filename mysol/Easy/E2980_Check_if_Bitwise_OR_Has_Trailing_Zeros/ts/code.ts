function hasTrailingZeros(nums: number[]): boolean {
  // Iterate through all pairs of elements in the array
  for (let i = 0; i < nums.length; i++) {
      for (let j = i + 1; j < nums.length; j++) {
          // Calculate the bitwise OR of nums[i] and nums[j]
          let bitwiseOr = nums[i] | nums[j];

          // Check if the bitwise OR has at least one trailing zero
          if ((bitwiseOr & 1) === 0) {
              return true; // Found at least one pair with trailing zero
          }
      }
  }

  // If no such pair is found, return false
  return false;
};

const input: number[] = [1,2,3,4,5];
const results = hasTrailingZeros(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

