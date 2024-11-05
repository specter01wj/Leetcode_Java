function countBeautifulPairs(nums: number[]): number {
  let count = 0;

  // Iterate through all pairs (i, j) where i < j
  for (let i = 0; i < nums.length; i++) {
      const firstDigit = getFirstDigit(nums[i]);

      for (let j = i + 1; j < nums.length; j++) {
          const lastDigit = getLastDigit(nums[j]);

          // Check if the first digit of nums[i] and the last digit of nums[j] are coprime
          if (gcd(firstDigit, lastDigit) === 1) {
              count++;
          }
      }
  }

  return count;
};

// Helper function to get the first digit of a number
function getFirstDigit(num: number): number {
  while (num >= 10) {
      num = Math.floor(num / 10);
  }
  return num;
}

// Helper function to get the last digit of a number
function getLastDigit(num: number): number {
  return num % 10;
}

// Helper function to find gcd of two numbers
function gcd(a: number, b: number): number {
  while (b !== 0) {
      const temp = b;
      b = a % b;
      a = temp;
  }
  return a;
}

const input: number[] = [11,21,12];
const results = countBeautifulPairs(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

