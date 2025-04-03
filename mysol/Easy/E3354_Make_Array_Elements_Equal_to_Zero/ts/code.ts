function countValidSelections(nums: number[]): number {
  let count = 0;

  for (let i = 0; i < nums.length; i++) {
      if (nums[i] === 0) {
          if (simulate([...nums], i, -1)) count++;
          if (simulate([...nums], i, 1)) count++;
      }
  }

  return count;
};

function simulate(arr: number[], curr: number, direction: number): boolean {
  const n = arr.length;

  while (curr >= 0 && curr < n) {
      if (arr[curr] === 0) {
          curr += direction;
      } else {
          arr[curr]--;
          direction *= -1;
          curr += direction;
      }
  }

  return arr.every(val => val === 0);
}

const input: number[] = [1,0,2,0,3];
const results = countValidSelections(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

