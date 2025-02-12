function numberOfPairs(nums1, nums2, k) {
    let count = 0;
    for (let i = 0; i < nums1.length; i++) {
        for (let j = 0; j < nums2.length; j++) {
            if (nums1[i] % (nums2[j] * k) === 0) {
                count++;
            }
        }
    }
    return count;
}
;
const nums1 = [1, 2, 4, 12], nums2 = [2, 4], k = 3;
const results = numberOfPairs(nums1, nums2, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(nums1, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
