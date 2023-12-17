function increasingTriplet(nums: number[]): boolean {
  if (nums === null || nums.length < 3) {
      return false;
  }

  let first = Number.MAX_SAFE_INTEGER;
  let second = Number.MAX_SAFE_INTEGER;

  for (let num of nums) {
      if (num <= first) {
          first = num;
      } else if (num <= second) {
          second = num;
      } else {
          return true;
      }
  }

  return false;
};

let input1 = [2,1,5,0,4,6];
let output1 = increasingTriplet(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

