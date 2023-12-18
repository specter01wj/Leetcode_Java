
function reduce(nums: number[], fn: (item: number, index: number) => number): number {
  let val = init;
  
  for (let i = 0; i < nums.length; i++) {
    val = fn(val, nums[i]);
  }

  return val;
}

function fn(a, b) {
  return a + b;
}

let input = [1, 2, 3, 4], init = 10;
let output1 = reduce(input, fn, init);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();



