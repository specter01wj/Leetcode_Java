function pivotIndex(nums: number[]): number {
  let totalSum = 0;
  let leftSum = 0;

  // Calculate the total sum of the array
  nums.forEach(num => totalSum += num);

  // Iterate through the array to find the pivot index
  for (let i = 0; i < nums.length; i++) {
      if (leftSum === totalSum - leftSum - nums[i]) {
          return i; // Found the pivot index
      }
      leftSum += nums[i]; // Update the left sum for the next iteration
  }

  return -1; // No pivot index found
};

let input1 = [1,7,3,6,5,6];
let output1 = pivotIndex(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

