function singleNumber(nums: number[]): number {
  let single: number = 0;

  for (let num of nums) {
      single ^= num;
  }

  return single;
};

let input1 = [4,1,2,1,2];
let output1 = singleNumber(input1);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(output1);

