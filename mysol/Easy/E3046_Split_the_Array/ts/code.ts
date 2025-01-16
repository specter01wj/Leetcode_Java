function isPossibleToSplit(nums: number[]): boolean {
  // Create a Map to count the frequency of each number
  const count: Map<number, number> = new Map();

  // Count the frequency of each number in the array
  for (const num of nums) {
      count.set(num, (count.get(num) || 0) + 1);
  }

  // Check if any number appears more than twice
  for (const val of count.values()) {
      if (val > 2) {
          return false; // If a number appears more than twice, splitting is not possible
      }
  }

  // If all numbers appear at most twice, splitting is possible
  return true;
};

const input: number[] = [1,1,2,2,3,4];
const results = isPossibleToSplit(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

