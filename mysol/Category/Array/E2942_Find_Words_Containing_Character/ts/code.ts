function maximumStrongPairXor(nums: number[]): number {
  const n = nums.length;
  let maxXor = 0;

  // Iterate through all possible pairs
  for (let i = 0; i < n; i++) {
      for (let j = i; j < n; j++) {
          const x = nums[i];
          const y = nums[j];

          // Check if the pair (x, y) is a strong pair
          if (Math.abs(x - y) <= Math.min(x, y)) {
              // Calculate XOR and update maxXor if it's larger
              maxXor = Math.max(maxXor, x ^ y);
          }
      }
  }

  return maxXor;
};

const input: number[] = [1,2,3,4,5];
const results = maximumStrongPairXor(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

