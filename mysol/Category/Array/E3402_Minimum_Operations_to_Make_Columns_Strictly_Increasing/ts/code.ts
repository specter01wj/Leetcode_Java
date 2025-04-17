function minimumOperations(nums: number[]): number {
  let ops = 0;
  let i = 0;

  while (i < nums.length) {
      const seen = new Set<number>();
      let hasDuplicate = false;

      for (let j = i; j < nums.length; j++) {
          if (seen.has(nums[j])) {
              hasDuplicate = true;
              break;
          }
          seen.add(nums[j]);
      }

      if (!hasDuplicate) {
          return ops;
      }

      // Simulate removing first 3 elements
      i += 3;
      ops++;
  }

  return ops;
};

const input: number[] = [1,2,3,4,2,3,3,5,7];
const results = minimumOperations(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

