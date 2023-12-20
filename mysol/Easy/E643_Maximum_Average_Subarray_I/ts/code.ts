function findMaxAverage(nums: number[], k: number): number {
  let sum = 0;
  for (let i = 0; i < k; i++) {
      sum += nums[i];
  }
  let max = sum;
  
  for (let i = k; i < nums.length; i++) {
      sum = sum - nums[i - k] + nums[i];
      max = Math.max(max, sum);
  }
  return max / k;
};

let input1 = [1,12,-5,-6,50,3], k = 4;
let output1 = findMaxAverage(input1, 4);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

