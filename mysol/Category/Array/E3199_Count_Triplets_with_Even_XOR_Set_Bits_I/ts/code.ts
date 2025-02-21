function minimumAverage(nums: number[]): number {
  nums.sort((a, b) => a - b);
  let averages: number[] = [];
  let left = 0, right = nums.length - 1;

  while (left < right) {
      let avg = (nums[left] + nums[right]) / 2;
      averages.push(avg);
      left++;
      right--;
  }

  return Math.min(...averages);
};

const input: number[] = [7,8,3,4,15,13,4,1];
const results = minimumAverage([...input]);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

