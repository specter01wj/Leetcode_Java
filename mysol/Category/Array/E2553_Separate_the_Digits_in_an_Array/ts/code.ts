function separateDigits(nums: number[]): number[] {
  const result: number[] = [];

  // Iterate through each number in the input array
  for (const num of nums) {
      // Convert the number to a string to separate its digits
      const numStr = num.toString();

      // Convert each character back to a number and add to the result array
      for (const digit of numStr) {
          result.push(Number(digit));
      }
  }

  return result;
};

const input: number[] = [13,25,83,77];
const results = separateDigits(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + results;

