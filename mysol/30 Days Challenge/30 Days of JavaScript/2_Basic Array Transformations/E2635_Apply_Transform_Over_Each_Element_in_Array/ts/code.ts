
function map(arr: number[], fn: (item: number, index: number) => number): number[] {
  let result: number[] = [];
  for (let i = 0; i < arr.length; i++) {
    result.push(fn(arr[i], i));
  }
  return result;
}

const fn = (element, index) => element * index;

let input = [1,2,3];
let output1 = map(input, fn);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();



