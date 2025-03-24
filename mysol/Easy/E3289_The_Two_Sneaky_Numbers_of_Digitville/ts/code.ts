function getSneakyNumbers(nums: number[]): number[] {
  const seen = new Set<number>();
  const result: number[] = [];

  for (const num of nums) {
      if (seen.has(num)) {
          result.push(num);
          if (result.length === 2) break;
      } else {
          seen.add(num);
      }
  }

  return result;
};

const input: number[] = [7,1,5,4,3,4,6,0,9,5,8,2];
const results = getSneakyNumbers(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

