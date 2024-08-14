
function missingNumber(arr: number[]): number {
  let n = arr.length;
  
  if (n === 1) return arr[0]; // If there's only one element, return it

  // Calculate the common difference as the difference between the first and last elements divided by the length of the array
  let diff = (arr[n - 1] - arr[0]) / n;

  for (let i = 0; i < n - 1; i++) {
      let currentDiff = arr[i + 1] - arr[i];
      if (currentDiff !== diff) {
          return arr[i] + diff;
      }
  }

  // Handle cases where all elements are the same, e.g., [0, 0, 0, 0, 0]
  if (diff === 0) {
      return arr[0];
  }

  // In case the input is malformed, return -1
  return -1;
};

const input: number[] = [5, 7, 11, 13];
const results = missingNumber(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;

