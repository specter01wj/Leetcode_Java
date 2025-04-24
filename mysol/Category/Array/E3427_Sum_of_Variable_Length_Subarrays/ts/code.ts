function subarraySum(nums: number[]): number {
  let totalSum = 0;

  for (let i = 0; i < nums.length; i++) {
      const start = Math.max(0, i - nums[i]);
      for (let j = start; j <= i; j++) {
          totalSum += nums[j];
      }
  }

  return totalSum;
};

const input: number[] = [2,3,1];
const results = subarraySum(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

