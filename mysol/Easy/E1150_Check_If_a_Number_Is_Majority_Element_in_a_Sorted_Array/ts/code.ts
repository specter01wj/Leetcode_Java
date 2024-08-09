
function isMajorityElement(nums: number[], target: number): boolean {
  const n = nums.length;
  const firstIndex = findFirstOccurrence(nums, target);

  // If the target is not found in the array
  if (firstIndex === -1) {
      return false;
  }

  // Check if the target appears more than n/2 times
  const majorityIndex = firstIndex + Math.floor(n / 2);
  if (majorityIndex < n && nums[majorityIndex] === target) {
      return true;
  }
  
  return false;
};

function findFirstOccurrence(nums: number[], target: number): number {
  let left = 0, right = nums.length - 1;
  while (left <= right) {
      const mid = Math.floor(left + (right - left) / 2);
      if (nums[mid] === target) {
          if (mid === 0 || nums[mid - 1] !== target) {
              return mid;
          } else {
              right = mid - 1;
          }
      } else if (nums[mid] < target) {
          left = mid + 1;
      } else {
          right = mid - 1;
      }
  }
  return -1;  // Target not found
}

const input: number[] = [2,4,5,5,5,5,5,6,6];
const target: number = 5;
const results = isMajorityElement(input, target);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

