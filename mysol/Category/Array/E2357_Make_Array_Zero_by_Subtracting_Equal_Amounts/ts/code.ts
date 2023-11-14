
function minimumOperations(nums: number[]): number {
  const set = new Set();
  for (let num of nums) {
    if (num > 0) {
      set.add(num);
    }
  }
  
  return set.size;
}

let input: number[] = [1,5,0,3,5];
let output = minimumOperations(input);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


