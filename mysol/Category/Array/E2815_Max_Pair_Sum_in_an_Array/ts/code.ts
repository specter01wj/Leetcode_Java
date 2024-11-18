function maxSum(nums: number[]): number {
  const maxNumByDigit: Map<number, number> = new Map(); // Map to store the maximum number for each largest digit
  let maxSum = -1;

  for (const num of nums) {
      const largestDigit = getLargestDigit(num);

      if (maxNumByDigit.has(largestDigit)) {
          // Calculate the pair sum
          const pairSum = maxNumByDigit.get(largestDigit)! + num;
          maxSum = Math.max(maxSum, pairSum);
          // Update the maximum number for this largest digit
          maxNumByDigit.set(largestDigit, Math.max(maxNumByDigit.get(largestDigit)!, num));
      } else {
          // Store the number for this largest digit
          maxNumByDigit.set(largestDigit, num);
      }
  }

  return maxSum;
};

// Helper function to find the largest digit in a number
function getLargestDigit(num: number): number {
  let largest = 0;
  while (num > 0) {
      largest = Math.max(largest, num % 10);
      num = Math.floor(num / 10);
  }
  return largest;
}

const input: number[] = [51,71,17,24,42];
const results = maxSum(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

