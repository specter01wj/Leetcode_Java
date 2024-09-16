function unequalTriplets(nums: number[]): number {
  let count = 0;
  let n = nums.length;
  
  // Iterate over all triplets (i, j, k)
  for (let i = 0; i < n - 2; i++) {
      for (let j = i + 1; j < n - 1; j++) {
          for (let k = j + 1; k < n; k++) {
              // Check if nums[i], nums[j], and nums[k] are distinct
              if (nums[i] !== nums[j] && nums[i] !== nums[k] && nums[j] !== nums[k]) {
                  count++;
              }
          }
      }
  }
  
  return count;
};

const input: number[] = [4,4,2,4,3];
const results = unequalTriplets(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

