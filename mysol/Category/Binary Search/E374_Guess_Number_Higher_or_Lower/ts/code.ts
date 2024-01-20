function guessNumber(n: number): number {
  let left = 1;
  let right = n;

  while (left <= right) {
      let mid = Math.floor((left + right) / 2);
      let res = guess(mid);

      if (res === 0) {
          // Correct guess
          return mid;
      } else if (res === -1) {
          // The number is lower than the guess
          right = mid - 1;
      } else {
          // The number is higher than the guess
          left = mid + 1;
      }
  }

  // Return -1 if the number is not found, although this should not happen in this game.
  return -1;
};

let pickedNumber: number = 10;

function guess(num: number): number {
    if (num > pickedNumber) {
        return -1; // num is higher than the picked number
    } else if (num < pickedNumber) {
        return 1; // num is lower than the picked number
    } else {
        return 0; // num is equal to the picked number
    }
}

let input1 = 100;
let output1 = guessNumber(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

