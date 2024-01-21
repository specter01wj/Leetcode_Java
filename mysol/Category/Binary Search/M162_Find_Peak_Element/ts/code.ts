function findPeakElement(nums: number[]): number {
  let left = 0, right = nums.length - 1;
  
  while (left < right) {
      let mid = Math.floor((left + right) / 2);

      if (nums[mid] > nums[mid + 1]) {
          // Peak is in the left half or at mid
          right = mid;
      } else {
          // Peak is in the right half
          left = mid + 1;
      }
  }
  
  // When left equals right, we have found the peak element
  return left;
};

let input1 = [1,2,1,3,5,6,4];
let output1 = findPeakElement(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

