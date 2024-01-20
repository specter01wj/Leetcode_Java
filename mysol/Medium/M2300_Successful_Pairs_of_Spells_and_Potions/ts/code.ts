function successfulPairs(spells: number[], potions: number[], success: number): number[] {
  // Sort the potions array
  potions.sort((a, b) => a - b);

  const n = spells.length;
  let pairs = new Array(n).fill(0);

  for (let i = 0; i < n; i++) {
      let left = 0;
      let right = potions.length - 1;

      // Apply binary search for each spell
      while (left <= right) {
          let mid = Math.floor((left + right) / 2);
          if (spells[i] * potions[mid] < success) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }

      // Count the number of successful pairs for the current spell
      pairs[i] = potions.length - left;
  }

  return pairs;
};

let spells = [5,1,3], potions = [1,2,3,4,5], success = 7;
let output1 = successfulPairs(spells, potions, success);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

