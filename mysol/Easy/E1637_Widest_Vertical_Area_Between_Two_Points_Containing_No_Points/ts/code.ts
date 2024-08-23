
function maxWidthOfVerticalArea(points: number[][]): number {
  // Extract the x-coordinates from the points
  const xCoords: number[] = points.map(point => point[0]);

  // Sort the x-coordinates
  xCoords.sort((a, b) => a - b);

  // Find the maximum gap between consecutive x-coordinates
  let maxWidth = 0;
  for (let i = 1; i < xCoords.length; i++) {
      const gap = xCoords[i] - xCoords[i - 1];
      if (gap > maxWidth) {
          maxWidth = gap;
      }
  }

  return maxWidth;
};

const input: number[][] = [[8,7],[9,9],[7,4],[9,7]];
const results = maxWidthOfVerticalArea(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

