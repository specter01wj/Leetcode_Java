function mergeArrays(nums1, nums2) {
    let result = [];
    let i = 0, j = 0;
    // Traverse both arrays
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i][0] === nums2[j][0]) {
            // If the ids are the same, sum their values
            result.push([nums1[i][0], nums1[i][1] + nums2[j][1]]);
            i++;
            j++;
        }
        else if (nums1[i][0] < nums2[j][0]) {
            // Add the id and value from nums1 if its id is smaller
            result.push([nums1[i][0], nums1[i][1]]);
            i++;
        }
        else {
            // Add the id and value from nums2 if its id is smaller
            result.push([nums2[j][0], nums2[j][1]]);
            j++;
        }
    }
    // Add remaining elements from nums1, if any
    while (i < nums1.length) {
        result.push([nums1[i][0], nums1[i][1]]);
        i++;
    }
    // Add remaining elements from nums2, if any
    while (j < nums2.length) {
        result.push([nums2[j][0], nums2[j][1]]);
        j++;
    }
    return result;
}
;
const nums1 = [[1, 2], [2, 3], [4, 5]];
const nums2 = [[1, 4], [3, 2], [4, 1]];
const results = mergeArrays(nums1, nums2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input1: ' + JSON.stringify(nums1, null, 2) +
    '; Input2: ' + JSON.stringify(nums2, null, 2) +
    '<br>Result = ' + JSON.stringify(results, null, 2);
