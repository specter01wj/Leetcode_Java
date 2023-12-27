function uniqueOccurrences(arr: number[]): boolean {
  let count: Record<number, number> = {};
  for (let a of arr) {
      count[a] = 1 + (count[a] || 0);
  }
  return Object.keys(count).length === new Set(Object.values(count)).size;
};

let input1 = [1,2,2,1,1,3];
let output1 = uniqueOccurrences(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

