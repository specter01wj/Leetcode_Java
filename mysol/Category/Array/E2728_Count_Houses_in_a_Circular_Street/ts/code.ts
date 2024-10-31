function semiOrderedPermutation(nums: number[]): number {
  const n = nums.length;
  let index1 = -1;
  let indexN = -1;

  // Find the positions of 1 and n in the array
  for (let i = 0; i < n; i++) {
      if (nums[i] === 1) index1 = i;
      if (nums[i] === n) indexN = i;
  }

  // Calculate moves to bring 1 to the start and n to the end
  let moves = index1 + (n - 1 - indexN);

  // If `1` is after `n`, one move overlaps, so we subtract 1
  if (index1 > indexN) moves -= 1;

  return moves;
};

const input: number[] = [2,4,1,3];
const results = semiOrderedPermutation(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

