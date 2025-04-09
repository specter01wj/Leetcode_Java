function constructTransformedArray(nums: number[]): number[] {
  const n: number = nums.length;
  const result: number[] = new Array(n);
  
  for (let i = 0; i < n; i++) {
      const steps: number = nums[i];
      if (steps === 0) {
          result[i] = nums[i];
      } else {
          let newIndex: number = (i + steps) % n;
          if (newIndex < 0) {
              newIndex += n;
          }
          result[i] = nums[newIndex];
      }
  }

  return result;
};

const input: number[] = [3,-2,1,1];
const results = constructTransformedArray(input);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

