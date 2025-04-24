function countPartitions(nums: number[]): number {
  const totalSum = nums.reduce((sum, num) => sum + num, 0);
  let leftSum = 0;
  let count = 0;

  for (let i = 0; i < nums.length - 1; i++) {
      leftSum += nums[i];
      const rightSum = totalSum - leftSum;

      if (Math.abs(leftSum - rightSum) % 2 === 0) {
          count++;
      }
  }

  return count;
};

const input: number[] = [10,10,3,7,6];
const results = countPartitions(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

