function findNonMinOrMax(nums: number[]): number {
  // If the array has fewer than 3 elements, return -1 as we can't have a middle element
  if (nums.length < 3) {
      return -1;
  }

  // Find the minimum and maximum values in the array
  const min = Math.min(...nums);
  const max = Math.max(...nums);

  // Return any number that is neither min nor max
  for (let num of nums) {
      if (num !== min && num !== max) {
          return num;
      }
  }

  return -1;
};

const input: number[] = [3,2,1,4];
const results = findNonMinOrMax(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

