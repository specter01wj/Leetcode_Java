function minOperations(nums, k) {
    // Sort the array in ascending order
    nums.sort((a, b) => a - b);
    let operations = 0;
    let i = 0;
    // Iterate through the array until all elements are >= k
    while (i < nums.length && nums[i] < k) {
        operations++;
        i++;
    }
    // Return the operations count
    return operations;
}
;
const input = [2, 11, 10, 1, 3];
const k = 10;
const originalArray = [...input];
const results = minOperations(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(originalArray, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
