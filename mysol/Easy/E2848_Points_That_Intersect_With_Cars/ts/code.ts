function numberOfPoints(nums: number[][]): number {
  const coveredPoints: Set<number> = new Set();

  // Iterate through each car's range
  for (const [start, end] of nums) {
      // Add all points within the range [start, end] to the set
      for (let i = start; i <= end; i++) {
          coveredPoints.add(i);
      }
  }

  // Return the total number of unique points
  return coveredPoints.size;
};

const input: number[][] = [[3,6],[1,5],[4,7]];
const results = numberOfPoints(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

