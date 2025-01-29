function addedInteger(nums1: number[], nums2: number[]): number {
  nums1.sort((a, b) => a - b);
  nums2.sort((a, b) => a - b);
  
  return nums2[Math.floor(nums2.length / 2)] - nums1[Math.floor(nums1.length / 2)];
};

const input1: number[] = [2,6,4], input2: number[] = [9,7,5];
let copyNums1 = [...input1];
let copyNums2 = [...input2];
const results = addedInteger(copyNums1, copyNums2);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input1, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);

