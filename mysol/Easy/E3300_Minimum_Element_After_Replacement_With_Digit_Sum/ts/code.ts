function minElement(nums: number[]): number {
  const digitSum = (num: number): number => {
      let sum = 0;
      while (num > 0) {
          sum += num % 10;
          num = Math.floor(num / 10);
      }
      return sum;
  };

  let min = Infinity;
  for (const num of nums) {
      min = Math.min(min, digitSum(num));
  }
  return min;
};

const input: number[] = [10,12,13,14];
const results = minElement(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

