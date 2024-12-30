function numberGame(nums: number[]): number[] {
  // Sort the array to handle minimum elements
  nums.sort((a, b) => a - b);

  // Result array to store the output
  const arr: number[] = [];

  // Simulate the game
  while (nums.length > 0) {
      // Alice removes the minimum element
      const alice = nums.shift()!; // Use `!` to indicate that shift won't return undefined

      // Bob removes the minimum element
      const bob = nums.shift()!; // Use `!` to indicate that shift won't return undefined

      // Bob appends to the array first, then Alice
      arr.push(bob);
      arr.push(alice);
  }

  return arr;
};

const input: number[] = [5,4,2,3];
const inputCopy = [...input];
const results = numberGame(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(inputCopy, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

