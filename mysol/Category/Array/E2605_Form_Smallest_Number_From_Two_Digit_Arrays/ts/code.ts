function minNumber(nums1: number[], nums2: number[]): number {
  // Step 1: Find the smallest common digit
  const set: Set<number> = new Set(nums1);
  let smallestCommon: number = Infinity;
  
  for (let num of nums2) {
      if (set.has(num)) {
          smallestCommon = Math.min(smallestCommon, num);
      }
  }
  
  if (smallestCommon !== Infinity) {
      return smallestCommon; // Found common digit, return it
  }
  
  // Step 2: No common digit, return smallest combination
  let minNum1: number = Math.min(...nums1);
  let minNum2: number = Math.min(...nums2);
  
  // Form the smallest two-digit number
  return Math.min(minNum1 * 10 + minNum2, minNum2 * 10 + minNum1);
};

const nums1: number[] = [4,1,3], nums2: number[] = [5,7];
const results = minNumber(nums1, nums2);

let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + JSON.stringify(nums1, null, 2) + 
    '; Input2: ' + JSON.stringify(nums2, null, 2) + 
    '<br>Result = ' + JSON.stringify(results, null, 2);

