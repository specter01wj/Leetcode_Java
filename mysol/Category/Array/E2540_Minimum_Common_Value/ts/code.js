function getCommon(nums1, nums2) {
    let i = 0, j = 0;
    // Use two pointers to traverse through both arrays
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] === nums2[j]) {
            return nums1[i]; // Common element found
        }
        else if (nums1[i] < nums2[j]) {
            i++; // Move pointer of nums1 forward
        }
        else {
            j++; // Move pointer of nums2 forward
        }
    }
    return -1; // No common element found
}
;
const nums1 = [1, 2, 3];
const nums2 = [2, 4];
const results = getCommon(nums1, nums2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + JSON.stringify(nums1, null, 2) +
    '; Input2: ' + JSON.stringify(nums2, null, 2) + '<br>Result = ' + results;
