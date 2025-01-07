function triangleType(nums: number[]): string {
  // Check if the array is valid and has exactly 3 elements
  if (!nums || nums.length !== 3) {
      return "none";
  }

  // Sort the array to simplify triangle inequality checks
  nums.sort((a, b) => a - b);

  // Check if the sides can form a triangle
  if (nums[0] + nums[1] <= nums[2]) {
      return "none";
  }

  // Check for equilateral triangle
  if (nums[0] === nums[1] && nums[1] === nums[2]) {
      return "equilateral";
  }

  // Check for isosceles triangle
  if (nums[0] === nums[1] || nums[1] === nums[2] || nums[0] === nums[2]) {
      return "isosceles";
  }

  // If none of the above, it's a scalene triangle
  return "scalene";
};

const input: number[] = [3,4,5];
const results = triangleType(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

