function transformArray(nums: number[]): number[] {
  // Step 1: Replace even with 0 and odd with 1
  for (let i = 0; i < nums.length; i++) {
      nums[i] = nums[i] % 2;
  }

  // Step 2: Sort the transformed array
  nums.sort((a, b) => a - b);

  return nums;
};

const input: number[] = [4,3,2,1];
const inputCopy: number[] = [...input];
const results = transformArray(inputCopy);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

