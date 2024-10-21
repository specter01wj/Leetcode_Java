function maxDivScore(nums: number[], divisors: number[]): number {
  let maxScore = -1;
  let resultDivisor = Infinity;

  // Iterate through each divisor
  for (let divisor of divisors) {
      let score = 0;

      // Calculate the divisibility score for the current divisor
      for (let num of nums) {
          if (num % divisor === 0) {
              score++;
          }
      }

      // Update the result if the current divisor has a higher score,
      // or if the score is the same but the divisor is smaller
      if (score > maxScore || (score === maxScore && divisor < resultDivisor)) {
          maxScore = score;
          resultDivisor = divisor;
      }
  }

  return resultDivisor;
};

const input: number[] = [2,9,15,50], divisors: number[] = [5,3,7,2];
const results = maxDivScore(input, divisors);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

