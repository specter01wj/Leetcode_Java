function maximumTripletValue(nums: number[]): number {
  let maxValue = 0;
  const n = nums.length;

  // Iterate through all possible triplets (i, j, k) where i < j < k
  for (let i = 0; i < n - 2; i++) {
      for (let j = i + 1; j < n - 1; j++) {
          for (let k = j + 1; k < n; k++) {
              // Calculate the triplet value
              const value = (nums[i] - nums[j]) * nums[k];
              // Update the maximum value
              maxValue = Math.max(maxValue, value);
          }
      }
  }

  return maxValue;
};

const input: number[] = [12,6,1,2,7];
const results = maximumTripletValue(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

