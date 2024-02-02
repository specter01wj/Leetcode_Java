function findMinArrowShots(points: number[][]): number {
  if (points.length === 0) {
      return 0;
  }
  
  // Sort the points array based on the end position of each interval
  points.sort((a, b) => a[1] - b[1]);
  
  let arrows = 1; // Start with one arrow
  let arrowPos = points[0][1]; // Position the first arrow at the end of the first balloon
  
  for (let i = 1; i < points.length; i++) {
      // If the current balloon starts after the arrow position,
      // it means a new arrow is needed for this and potentially following balloons
      if (points[i][0] > arrowPos) {
          arrows++;
          arrowPos = points[i][1]; // Update the arrow position to the end of the current balloon
      }
      // If the current balloon starts before or at the arrow position,
      // it is already burst by the current arrow, so we do nothing
  }
  
  return arrows;
};

let input1 = [[10,16],[2,8],[1,6],[7,12]];
let output1 = findMinArrowShots(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

