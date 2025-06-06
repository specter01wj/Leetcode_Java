function sumOfGoodNumbers(nums: number[], k: number): number {
  let sum: number = 0;

  for (let i = 0; i < nums.length; i++) {
      let isGood: boolean = true;

      // Check left neighbor at index i - k
      if (i - k >= 0 && nums[i] <= nums[i - k]) {
          isGood = false;
      }

      // Check right neighbor at index i + k
      if (i + k < nums.length && nums[i] <= nums[i + k]) {
          isGood = false;
      }

      // If number is good, add to sum
      if (isGood) {
          sum += nums[i];
      }
  }

  return sum;
};

const input: number[] = [1,3,2,1,5,4];
const k: number = 2;
const results = sumOfGoodNumbers(input, k);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

