function getFinalState(nums: number[], k: number, multiplier: number): number[] {
  for (let i = 0; i < k; i++) {
      let minIndex = 0;
      for (let j = 1; j < nums.length; j++) {
          if (nums[j] < nums[minIndex]) {
              minIndex = j;
          }
      }
      nums[minIndex] *= multiplier;
  }
  return nums;
};

const input: number[] = [2,1,3,5,6];
const k: number = 2, multiplier: number = 2;
const inputCopy: number[] = [...input];
const results = getFinalState(inputCopy, k, multiplier);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

