function findKthLargest(nums: number[], k: number): number {
  return quickSort(nums, 0, nums.length - 1, k);
};

function quickSort(nums: number[], left: number, right: number, k: number): number {
  if (left <= right) {
      let p = partition(nums, left, right);
      if (p == nums.length - k) {
          return nums[p];
      } else if (p > nums.length - k) {
          return quickSort(nums, left, p - 1, k);
      } else {
          return quickSort(nums, p + 1, right, k);
      }
  }
  return -1; // This line is reached only if the input array is empty
}

function partition(nums: number[], left: number, right: number): number {
  let pivot = nums[left];
  let i = left + 1, j = right;

  while (true) {
      while (i <= right && nums[i] < pivot) {
          i++;
      }
      while (j >= left + 1 && nums[j] > pivot) {
          j--;
      }
      if (i > j) {
          break;
      }
      [nums[i], nums[j]] = [nums[j], nums[i]]; // Swap using destructuring assignment
      i++;
      j--;
  }
  [nums[left], nums[j]] = [nums[j], nums[left]]; // Swap pivot into correct position
  return j;
}

let input1 = [3,2,1,5,6,4];
let k = 2;
let output1 = findKthLargest(input1, k);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

