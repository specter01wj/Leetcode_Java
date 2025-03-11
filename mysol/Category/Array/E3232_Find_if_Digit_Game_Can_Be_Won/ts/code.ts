function canAliceWin(nums: number[]): boolean {
  let singleDigitSum = 0, doubleDigitSum = 0;

  // Calculate the sum of single-digit and double-digit numbers
  for (let num of nums) {
      if (num < 10) {
          singleDigitSum += num;
      } else if (num < 100) {
          doubleDigitSum += num;
      }
  }

  // Calculate Bob's sums in each case
  let bobSumWhenAliceTakesSingles = doubleDigitSum;
  let bobSumWhenAliceTakesDoubles = singleDigitSum;

  // Check if Alice can win in either case
  return singleDigitSum > bobSumWhenAliceTakesSingles || doubleDigitSum > bobSumWhenAliceTakesDoubles;
};

const input: number[] = [1,2,3,4,5,14];
const results = canAliceWin(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

