
function filter(arr: number[], fn: (item: number, index: number) => boolean): number[] {
  let filteredArr: number[] = [];

  for (let i = 0; i < arr.length; i++) {
    if (fn(arr[i], i)) {
      filteredArr.push(arr[i]);
    }
  }

  return filteredArr;
}

function fn(number, index) {
  return number % index === 0;
}

let input = [0, 1, 2, 4, 6, 10];
let output1 = filter(input, fn);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();



