function applyOperations(nums) {
    const n = nums.length;
    // Apply the operations on the array
    for (let i = 0; i < n - 1; i++) {
        if (nums[i] === nums[i + 1]) {
            nums[i] *= 2;
            nums[i + 1] = 0;
        }
    }
    // Shift all 0s to the end of the array
    const result = [];
    // First, push non-zero elements to the result array
    for (let i = 0; i < n; i++) {
        if (nums[i] !== 0) {
            result.push(nums[i]);
        }
    }
    // Fill the remaining space with 0s
    while (result.length < n) {
        result.push(0);
    }
    return result;
}
;
const input = [1, 2, 2, 1, 1, 0];
const inputCopy = [...input];
const results = applyOperations(inputCopy);
let webHeading = document.querySelector('#t1');
webHeading.innerHTML = 'Input: ' + input + '<br>Result = ' + results;
