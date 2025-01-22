function resultArray(nums: number[]): number[] {
  let arr1: number[] = [];
  let arr2: number[] = [];

  // Add the first element to arr1 and the second element to arr2
  arr1.push(nums[0]);
  arr2.push(nums[1]);

  // Start from the third element
  for (let i = 2; i < nums.length; i++) {
      if (arr1[arr1.length - 1] > arr2[arr2.length - 1]) {
          arr1.push(nums[i]);
      } else {
          arr2.push(nums[i]);
      }
  }

  // Combine arr1 and arr2 into the result array
  return [...arr1, ...arr2];
};

const input: number[] = [5,4,3,8];
const results = resultArray(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

