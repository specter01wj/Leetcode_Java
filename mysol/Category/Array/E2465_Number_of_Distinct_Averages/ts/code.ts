function distinctAverages(nums: number[]): number {
  // Sort the array to easily find the minimum and maximum
  nums.sort((a, b) => a - b);
  const distinctAverages = new Set<number>();

  let left = 0;
  let right = nums.length - 1;

  // Calculate the average of the minimum and maximum numbers, then remove them
  while (left < right) {
      const average = (nums[left] + nums[right]) / 2;
      distinctAverages.add(average);
      left++;
      right--;
  }

  // The size of the set represents the number of distinct averages
  return distinctAverages.size;
};

const input: number[] = [4,1,4,0,3,5];
const inputCopy: number[] = [...input];
const results = distinctAverages(inputCopy);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

