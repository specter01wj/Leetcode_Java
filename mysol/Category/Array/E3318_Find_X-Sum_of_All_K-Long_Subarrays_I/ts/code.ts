function minBitwiseArray(nums: number[]): number[] {
  const ans: number[] = [];

  for (let i = 0; i < nums.length; i++) {
      const num = nums[i];
      let found = false;

      for (let x = 0; x <= num; x++) {
          if ((x | (x + 1)) === num) {
              ans.push(x);
              found = true;
              break;
          }
      }

      if (!found) {
          ans.push(-1);
      }
  }

  return ans;
};

const input: number[] = [2,3,5,7];
const results = minBitwiseArray(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

