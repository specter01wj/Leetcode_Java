function sumIndicesWithKSetBits(nums: number[], k: number): number {
  let sum = 0;

  // Iterate through each index of the array
  for (let i = 0; i < nums.length; i++) {
      if (countSetBits(i) === k) {
          sum += nums[i];
      }
  }

  return sum;
};

// Helper function to count the number of set bits (1s) in the binary representation of a number
function countSetBits(n: number): number {
  let count = 0;
  while (n > 0) {
      count += (n & 1); // Increment if the last bit is 1
      n >>= 1;          // Right shift to process the next bit
  }
  return count;
}

const input: number[] = [5,10,1,5,2];
const k: number = 1;
const results = sumIndicesWithKSetBits(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

