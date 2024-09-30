function distinctIntegers(n: number): number {
  // If n is 1, return 1 since only 1 remains on the board
  if (n === 1) {
      return 1;
  }
  
  // For any n > 1, the result is n - 1 distinct integers
  return n - 1;
};

const input: number = 5;
const results = distinctIntegers(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;

