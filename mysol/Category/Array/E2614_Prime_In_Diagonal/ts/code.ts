function diagonalPrime(nums: number[][]): number {
  // Helper function to check if a number is prime
  const isPrime = (num: number): boolean => {
      if (num <= 1) return false;
      for (let i = 2; i * i <= num; i++) {
          if (num % i === 0) return false;
      }
      return true;
  };

  let maxPrime: number = 0;
  const n: number = nums.length;

  for (let i = 0; i < n; i++) {
      // Check the first diagonal (nums[i][i])
      if (isPrime(nums[i][i])) {
          maxPrime = Math.max(maxPrime, nums[i][i]);
      }
      
      // Check the second diagonal (nums[i][n - i - 1])
      if (isPrime(nums[i][n - i - 1])) {
          maxPrime = Math.max(maxPrime, nums[i][n - i - 1]);
      }
  }

  return maxPrime;
};

const input: number[][] = [[1,2,3],[5,6,7],[9,10,11]];
const results = diagonalPrime(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

