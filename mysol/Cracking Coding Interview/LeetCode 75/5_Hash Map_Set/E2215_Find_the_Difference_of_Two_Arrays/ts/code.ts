function findDifference(nums1: number[], nums2: number[]): number[][] {
  const set1 = new Set<number>(nums1);
  const set2 = new Set<number>(nums2);

  const result: number[][] = [[], []];

  set1.forEach(num => {
      if (!set2.has(num)) {
          result[0].push(num);
      }
  });

  set2.forEach(num => {
      if (!set1.has(num)) {
          result[1].push(num);
      }
  });

  return result;
};

let nums1 = [1,2,3], nums2 = [2,4,6];
let output1 = findDifference(nums1, nums2);

let webHeading1 = document.querySelector('#t1');
webHeading1.textContent = 'Output: ' + JSON.stringify(nums1);

