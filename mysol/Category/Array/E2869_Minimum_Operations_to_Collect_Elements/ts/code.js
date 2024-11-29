function minOperations(nums, k) {
    const collected = new Set();
    let operations = 0;
    // Iterate from the end of the array
    for (let i = nums.length - 1; i >= 0; i--) {
        if (nums[i] <= k) {
            collected.add(nums[i]);
        }
        operations++;
        // Check if all elements from 1 to k are collected
        if (collected.size === k) {
            break;
        }
    }
    return operations;
}
;
const input = [3, 1, 5, 4, 2];
const k = 2;
const results = minOperations(input, k);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + JSON.stringify(input, null, 2) + '<br>Result = ' + JSON.stringify(results, null, 2);
