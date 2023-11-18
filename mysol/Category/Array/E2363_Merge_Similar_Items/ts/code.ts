
function mergeSimilarItems(items1: [number, number][], items2: [number, number][]): [number, number][] {
  const map: { [key: number]: number } = {};
  const items = [...items1, ...items2];
  
  // Sum weights for each unique value
  for (const [val, weight] of items) {
      if (map[val]) {
          map[val] += weight;
      } else {
          map[val] = weight;   
      }
  }
  
  // Convert the map to an array, sort it by value, and return
  return Object.entries(map).map(([value, weight]) => [parseInt(value, 10), weight])
                             .sort((a, b) => a[0] - b[0]);
}

let input1: [number, number][] = [[1,1],[4,5],[3,8]], input2: [number, number][] = [[3,1],[1,5]];
let output = mergeSimilarItems(input1, input2);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


