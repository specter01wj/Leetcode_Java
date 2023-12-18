function productExceptSelf(nums: number[]): number[] {
  let length = nums.length;

  let leftProducts: number[] = new Array(length);
  let rightProducts: number[] = new Array(length);

  let answer: number[] = new Array(length);

  leftProducts[0] = 1;
  for (let i = 1; i < length; i++) {
      leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
  }

  rightProducts[length - 1] = 1;
  for (let i = length - 2; i >= 0; i--) {
      rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
  }

  for (let i = 0; i < length; i++) {
      answer[i] = leftProducts[i] * rightProducts[i];
  }

  return answer;
};

let input1 = [1,2,3,4];
let output1 = productExceptSelf(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + output1.toString();

