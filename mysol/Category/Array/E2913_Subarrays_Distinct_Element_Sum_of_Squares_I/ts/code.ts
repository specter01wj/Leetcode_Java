function sumCounts(nums: number[]): number {
  const n = nums.length;
  let totalSum = 0;

  // Iterate over all possible subarray starting points
  for (let i = 0; i < n; i++) {
      const distinctSet: Set<number> = new Set();

      // Iterate over all possible subarray ending points
      for (let j = i; j < n; j++) {
          // Add the current element to the distinct set
          distinctSet.add(nums[j]);

          // Get the size of the set (distinct count) and add its square to totalSum
          const distinctCount = distinctSet.size;
          totalSum += distinctCount * distinctCount;
      }
  }

  return totalSum;
};

const input: number[] = [1,2,1;
const results = sumCounts(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

