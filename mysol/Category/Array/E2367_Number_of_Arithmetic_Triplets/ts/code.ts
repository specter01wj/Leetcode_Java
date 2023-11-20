
function arithmeticTriplets(nums: number[], diff: number): number {
  let cnt: number = 0;
  let numberSet: Set<number> = new Set();
  for (let num of nums) {
    if (numberSet.has(num - diff) && numberSet.has(num - diff * 2)) {
      ++cnt;
    }
    numberSet.add(num);
  }
  
  return cnt;
}

let input: number[] = [0,1,4,6,7,10], diff: number = 3;
let output = arithmeticTriplets(input, diff);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


