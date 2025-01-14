function maxOperations(nums: number[]): number {
  if (nums.length < 2) return 0;

  // Calculate the initial score using the first two elements
  let prev = nums[0] + nums[1];
  let count = 1;

  // Iterate through the array, checking pairs of elements
  for (let i = 2; i < nums.length - 1; i += 2) {
      // If the current pair's sum matches the previous score, increment count
      if (nums[i] + nums[i + 1] === prev) {
          count++;
      } else {
          // If the score changes, stop processing further
          break;
      }
  }

  // Return the maximum number of operations with the same score
  return count;
};

const input: number[] = [3,2,1,4,5];
const results = maxOperations(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

