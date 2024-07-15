
function findSubarrays(nums: number[]): boolean {
  let seenSums: Set<number> = new Set();

  for (let i = 0; i < nums.length - 1; i++) {
      let sum = nums[i] + nums[i + 1];
      if (seenSums.has(sum)) {
          return true;
      }
      seenSums.add(sum);
  }

  return false;
}

let nums = [4,2,4];
let output = findSubarrays(nums);

let webHeading = document.querySelector('#t1');
webHeading.textContent = 'Output: ' + output.toString();


