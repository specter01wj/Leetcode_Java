function minimumCost(nums: number[]): number {
  const n = nums.length;
  if (n < 3) {
      return -1; // Return -1 for invalid input
  }

  // Initialize the minimum cost to a high value
  let minCost = Infinity;

  // Iterate through all possible divisions of the array into 3 subarrays
  for (let i = 1; i < n - 1; i++) {
      for (let j = i + 1; j < n; j++) {
          // Divide the array into three subarrays
          const cost1 = nums[0]; // First subarray starts at index 0
          const cost2 = nums[i]; // Second subarray starts at index i
          const cost3 = nums[j]; // Third subarray starts at index j

          // Calculate the total cost for this division
          const totalCost = cost1 + cost2 + cost3;

          // Update the minimum cost if needed
          minCost = Math.min(minCost, totalCost);
      }
  }

  return minCost;
};

const input: number[] = [1,2,3,12];
const results = minimumCost(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

