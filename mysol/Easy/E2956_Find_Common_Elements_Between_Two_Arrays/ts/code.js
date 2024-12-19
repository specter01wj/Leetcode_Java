function findIntersectionValues(nums1, nums2) {
    // Create sets to store the elements of each array
    const set1 = new Set(nums1);
    const set2 = new Set(nums2);
    // Count indices in nums1 that exist in nums2
    let answer1 = 0;
    for (const num of nums1) {
        if (set2.has(num)) {
            answer1++;
        }
    }
    // Count indices in nums2 that exist in nums1
    let answer2 = 0;
    for (const num of nums2) {
        if (set1.has(num)) {
            answer2++;
        }
    }
    return [answer1, answer2];
}
;
const input1 = [4, 3, 2, 3, 1], input2 = [2, 2, 5, 2, 3, 6];
const results = findIntersectionValues(input1, input2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input1, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
