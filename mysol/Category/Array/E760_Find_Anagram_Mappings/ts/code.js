function anagramMappings(nums1, nums2) {
    // Create a map to store the value-to-index mappings for nums2
    let indexMap = new Map();
    for (let i = 0; i < nums2.length; i++) {
        indexMap.set(nums2[i], i);
    }
    // Create the result array to store the mappings
    let result = new Array(nums1.length);
    for (let i = 0; i < nums1.length; i++) {
        result[i] = indexMap.get(nums1[i]);
    }
    return result;
}
const nums1 = [12, 28, 46, 32, 50];
const nums2 = [50, 12, 32, 46, 28];
const results = anagramMappings(nums1, nums2);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + nums1 + ' and ' + nums2 + '<br>Result = ' + results;
