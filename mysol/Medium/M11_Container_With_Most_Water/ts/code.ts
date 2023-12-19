function maxArea(height: number[]): number {
  let maxArea = 0;
  let left = 0;
  let right = height.length - 1;

  while (left < right) {
      // Calculate the area
      const width = right - left;
      const minHeight = Math.min(height[left], height[right]);
      const area = width * minHeight;

      // Update the maximum area
      maxArea = Math.max(maxArea, area);

      // Move the pointer pointing to the shorter line inward
      if (height[left] < height[right]) {
          left++;
      } else {
          right--;
      }
  }

  return maxArea;
};

let input1 = [1,8,6,2,5,4,8,3,7];
let output1 = maxArea(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

