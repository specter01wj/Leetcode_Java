function moveZeroes(nums: number[]): void {
  // Initialize a pointer for the next position to place a non-zero number
  let insertPos = 0;
  let res = JSON.parse(JSON.stringify(nums));

  // Traverse the array, moving non-zero numbers to the front
  for (let num of nums) {
      if (num !== 0) {
        res[insertPos++] = num;
      }
  }

  // Fill the remaining array with zeroes
  while (insertPos < nums.length) {
    res[insertPos++] = 0;
  }

  return res;
};

let input1 = [0,1,0,3,12];
let output1 = moveZeroes(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

