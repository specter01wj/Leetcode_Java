function maxOperations(nums: number[], k: number): number {
  const numCounts = new Map<number, number>();
  let operations = 0;

  for (let num of nums) {
      const complement = k - num;
      // Check if the complement is present and has a non-zero count
      if (numCounts.get(complement) > 0) {
          // Perform an operation and decrease the count of the complement
          operations++;
          numCounts.set(complement, numCounts.get(complement)! - 1);
      } else {
          // Otherwise, increase the count of the current number
          numCounts.set(num, (numCounts.get(num) || 0) + 1);
      }
  }

  return operations;
};

let input1 = [1,2,3,4], k = 5;
let output1 = maxOperations(input1, k);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

